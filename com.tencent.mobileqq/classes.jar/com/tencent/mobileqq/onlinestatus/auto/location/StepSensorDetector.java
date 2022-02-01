package com.tencent.mobileqq.onlinestatus.auto.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import androidx.annotation.RequiresApi;

public class StepSensorDetector
  extends StepMovementDetector
{
  @RequiresApi(api=19)
  StepSensorDetector()
  {
    super(18);
    this.a = "StepSensorDetector";
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.StepSensorDetector
 * JD-Core Version:    0.7.0.1
 */