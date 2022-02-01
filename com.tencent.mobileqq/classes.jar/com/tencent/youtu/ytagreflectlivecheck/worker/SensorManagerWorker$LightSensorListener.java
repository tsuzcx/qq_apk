package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class SensorManagerWorker$LightSensorListener
  implements SensorEventListener
{
  private float lux;
  
  private SensorManagerWorker$LightSensorListener(SensorManagerWorker paramSensorManagerWorker) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 5)
    {
      this.lux = paramSensorEvent.values[0];
      if (SensorManagerWorker.access$400(this.this$0) != null) {
        SensorManagerWorker.access$400(this.this$0).onGetValue(this.lux);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker.LightSensorListener
 * JD-Core Version:    0.7.0.1
 */