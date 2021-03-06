/*******************************************************************************
 *  Copyright (C) Xueyi Zou - All Rights Reserved
 *  Written by Xueyi Zou <xz972@york.ac.uk>, 2015
 *  You are free to use/modify/distribute this file for whatever purpose!
 *  -----------------------------------------------------------------------
 *  |THIS FILE IS DISTRIBUTED "AS IS", WITHOUT ANY EXPRESS OR IMPLIED
 *  |WARRANTY. THE USER WILL USE IT AT HIS/HER OWN RISK. THE ORIGINAL
 *  |AUTHORS AND COPPELIA ROBOTICS GMBH WILL NOT BE LIABLE FOR DATA LOSS,
 *  |DAMAGES, LOSS OF PROFITS OR ANY OTHER KIND OF LOSS WHILE USING OR
 *  |MISUSING THIS SOFTWARE.
 *  ------------------------------------------------------------------------
 *******************************************************************************/
package visualization.configuration;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import search.EvolutionarySearch;
import sim.display.GUIState;
import sim.engine.SimState;

public class GlobalConfigurator extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public static Configuration config= Configuration.getInstance();

	public GlobalConfigurator(SimState simState, GUIState guiState) 
	{
		setLayout(null);
		
		JRadioButton rdbtnCAEnable = new JRadioButton("CA Enable?");
		rdbtnCAEnable.setBounds(12, 20, 102, 15);
		this.add(rdbtnCAEnable);
		rdbtnCAEnable.setSelected(config.globalConfig.collisionAvoidanceEnabler);
		rdbtnCAEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((JRadioButton)e.getSource()).isSelected())
				{
					config.globalConfig.collisionAvoidanceEnabler = true;
				} else {
					
					config.globalConfig.collisionAvoidanceEnabler = false;
				}
			}
		});
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String result = JOptionPane.showInputDialog(null, "copy and paste:", "Genome",JOptionPane.PLAIN_MESSAGE);

				if(result!=null && !result.isEmpty())
				{
					EvolutionarySearch.genomeString2Config(result);				
							   
					SAAConfigurator theSAAConfigurator = ((SAAConfigurator)((JButton)e.getSource()).getRootPane().getParent());
					theSAAConfigurator.refresh();	
				}
			}
		});
		btnLoad.setBounds(225, 15, 77, 25);
		this.add(btnLoad);
		
		JRadioButton rdbtnCoordinationEnable = new JRadioButton("Coordination Enable?");
		rdbtnCoordinationEnable.setBounds(12, 40, 190, 15);
		this.add(rdbtnCoordinationEnable);
		rdbtnCoordinationEnable.setSelected(config.globalConfig.coordinationEnabler);
		rdbtnCoordinationEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((JRadioButton)e.getSource()).isSelected())
				{
					config.globalConfig.coordinationEnabler = true;
				} else {
					
					config.globalConfig.coordinationEnabler = false;
				}
			}
		});
		
		JRadioButton rdbtnAccidentDetectorEnable = new JRadioButton("AccidentDetector Enable?");
		rdbtnAccidentDetectorEnable.setBounds(12, 60, 229, 15);
		this.add(rdbtnAccidentDetectorEnable);
		rdbtnAccidentDetectorEnable.setSelected(config.globalConfig.accidentDetectorEnabler);
		rdbtnAccidentDetectorEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((JRadioButton)e.getSource()).isSelected())
				{
					config.globalConfig.accidentDetectorEnabler = true;
				} else {
					
					config.globalConfig.accidentDetectorEnabler = false;
				}
			}
		});
		
		JRadioButton rdbtnWhiteNoiseEnabler = new JRadioButton("white noise enable?");
		rdbtnWhiteNoiseEnabler.setBounds(12, 80, 229, 15);
		this.add(rdbtnWhiteNoiseEnabler);
		rdbtnWhiteNoiseEnabler.setSelected(config.globalConfig.whiteNoiseEnabler);
		rdbtnWhiteNoiseEnabler.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				if(((JRadioButton)e.getSource()).isSelected())
				{
					config.globalConfig.whiteNoiseEnabler = true;
				} else {
					
					config.globalConfig.whiteNoiseEnabler = false;
				}
			}
		});
			
		{			
			JPanel performancePanel = new JPanel();
			performancePanel.setBackground(Color.LIGHT_GRAY);
			performancePanel.setBounds(12, 112, 290, 143);
			add(performancePanel);
			performancePanel.setLayout(null);
			JLabel lblMaxspeed = new JLabel("MaxGS");
			lblMaxspeed.setBounds(12, 14, 82, 15);
			performancePanel.add(lblMaxspeed);
			
			
			JTextField maxSpeedTextField_1 = new JTextField();
			maxSpeedTextField_1.setBounds(170, 14, 114, 19);
			performancePanel.add(maxSpeedTextField_1);
			maxSpeedTextField_1.setText(String.valueOf(config.globalConfig.maxGS));
			maxSpeedTextField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					JTextField maxSpeedTextField = (JTextField) e.getSource();
					config.globalConfig.maxGS = new Double(maxSpeedTextField.getText());
				}
			});
			maxSpeedTextField_1.setColumns(10);
			
			
			JLabel lblMinspeed = new JLabel("MinGS");
			lblMinspeed.setBounds(12, 43, 70, 19);
			performancePanel.add(lblMinspeed);
			
			
			JTextField minSpeedTextField_1 = new JTextField();
			minSpeedTextField_1.setBounds(170, 45, 114, 19);
			performancePanel.add(minSpeedTextField_1);
			minSpeedTextField_1.setText(String.valueOf(config.globalConfig.minGS));
			minSpeedTextField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					JTextField minSpeedTextField = (JTextField) e.getSource();
					config.globalConfig.minGS = new Double(minSpeedTextField.getText());
				}
			});
			minSpeedTextField_1.setColumns(10);
					
			JLabel lblMaxClimb = new JLabel("MaxVS");
			lblMaxClimb.setBounds(11, 75, 70, 19);
			performancePanel.add(lblMaxClimb);
			
			
			JTextField maxClimbTextField_1 = new JTextField();
			maxClimbTextField_1.setBounds(169, 73, 114, 19);
			performancePanel.add(maxClimbTextField_1);
			maxClimbTextField_1.setText(String.valueOf(config.globalConfig.maxVS));
			maxClimbTextField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					JTextField maxClimbTextField = (JTextField) e.getSource();
					config.globalConfig.maxVS = new Double(maxClimbTextField.getText());
				}
			});
			maxClimbTextField_1.setColumns(10);
			
			JLabel lblMaxDescent = new JLabel("MinVS");
			lblMaxDescent.setBounds(11, 105, 101, 19);
			performancePanel.add(lblMaxDescent);
			
			
			JTextField maxDescentTextField_1 = new JTextField();
			maxDescentTextField_1.setBounds(169, 107, 114, 19);
			performancePanel.add(maxDescentTextField_1);
			maxDescentTextField_1.setText(String.valueOf(config.globalConfig.minVS));
			maxDescentTextField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					JTextField maxDescentTextField = (JTextField) e.getSource();
					config.globalConfig.minVS = new Double(maxDescentTextField.getText());
				}
			});
			maxDescentTextField_1.setColumns(10);
			
		}
	
		
		{
			JPanel noisePanel = new JPanel();
			noisePanel.setBounds(12, 269, 290, 95);
			add(noisePanel);
			noisePanel.setLayout(null);
			
			JLabel lblStdDevX = new JLabel("SDX");
			lblStdDevX.setBounds(15, 5, 28, 15);
			noisePanel.add(lblStdDevX);
			
			final JLabel stdDevXLabel = new JLabel(""+config.globalConfig.stdDevX);
			stdDevXLabel.setBounds(250, 6, 56, 15);
			noisePanel.add(stdDevXLabel);
			
			JSlider ownshipStdDevXSlider = new JSlider();
			ownshipStdDevXSlider.setBounds(53, 5, 193, 16);
			noisePanel.add(ownshipStdDevXSlider);
			ownshipStdDevXSlider.setSnapToTicks(true);
			ownshipStdDevXSlider.setPaintLabels(true);		
			ownshipStdDevXSlider.setMaximum(6);
			ownshipStdDevXSlider.setMinimum(0);
			ownshipStdDevXSlider.setValue((int)(config.globalConfig.stdDevX));
			ownshipStdDevXSlider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					JSlider source = (JSlider) e.getSource();
					config.globalConfig.stdDevX = source.getValue();
					stdDevXLabel.setText(""+config.globalConfig.stdDevX);
				}
			});
			
			JLabel lblStdDevY = new JLabel("SDY");
			lblStdDevY.setBounds(15, 32, 27, 15);
			noisePanel.add(lblStdDevY);
			
			final JLabel stdDevYLabel = new JLabel(""+config.globalConfig.stdDevY);
			stdDevYLabel.setBounds(250, 31, 56, 15);
			noisePanel.add(stdDevYLabel);
			
			JSlider ownshipStdDevYSlider = new JSlider();
			ownshipStdDevYSlider.setBounds(53, 31, 193, 16);
			noisePanel.add(ownshipStdDevYSlider);
			ownshipStdDevYSlider.setSnapToTicks(true);
			ownshipStdDevYSlider.setPaintLabels(true);		
			ownshipStdDevYSlider.setMaximum(6);
			ownshipStdDevYSlider.setMinimum(0);
			ownshipStdDevYSlider.setValue((int)(config.globalConfig.stdDevY));
			ownshipStdDevYSlider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					JSlider source = (JSlider) e.getSource();
					config.globalConfig.stdDevY = source.getValue();
					stdDevYLabel.setText(""+config.globalConfig.stdDevY);
				}
			});
		
			
			JLabel lblStdDevZ = new JLabel("SDZ");
			lblStdDevZ.setBounds(15, 59, 29, 15);
			noisePanel.add(lblStdDevZ);
			
			final JLabel stdDevZLabel = new JLabel(""+config.globalConfig.stdDevZ);
			stdDevZLabel.setBounds(250, 58, 56, 15);
			noisePanel.add(stdDevZLabel);
			
			JSlider ownshipStdDevZSlider = new JSlider();
			ownshipStdDevZSlider.setBounds(53, 58, 193, 16);
			noisePanel.add(ownshipStdDevZSlider);
			ownshipStdDevZSlider.setSnapToTicks(true);
			ownshipStdDevZSlider.setPaintLabels(true);		
			ownshipStdDevZSlider.setMaximum(6);
			ownshipStdDevZSlider.setMinimum(0);
			ownshipStdDevZSlider.setValue((int)(config.globalConfig.stdDevZ));
			ownshipStdDevZSlider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					JSlider source = (JSlider) e.getSource();
					config.globalConfig.stdDevZ = source.getValue();
					stdDevZLabel.setText(""+config.globalConfig.stdDevZ);
				}
			});
			
		}			
			
	}
}
