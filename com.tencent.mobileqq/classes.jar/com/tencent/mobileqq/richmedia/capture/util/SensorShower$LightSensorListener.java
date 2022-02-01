package com.tencent.mobileqq.richmedia.capture.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class SensorShower$LightSensorListener
  implements SensorEventListener
{
  private float b;
  
  private SensorShower$LightSensorListener(SensorShower paramSensorShower) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 5)
    {
      this.b = paramSensorEvent.values[0];
      if (SensorShower.a(this.a) != null) {
        SensorShower.a(this.a).a(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.SensorShower.LightSensorListener
 * JD-Core Version:    0.7.0.1
 */