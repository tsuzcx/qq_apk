package com.tencent.mobileqq.onlinestatus.auto.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class StepEmptySensor
  extends StepMovementDetector
{
  StepEmptySensor()
  {
    super(1);
    this.a = "StepEmptySensor";
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.StepEmptySensor
 * JD-Core Version:    0.7.0.1
 */