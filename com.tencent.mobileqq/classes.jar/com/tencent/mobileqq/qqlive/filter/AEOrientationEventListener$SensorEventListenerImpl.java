package com.tencent.mobileqq.qqlive.filter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.OrientationListener;

class AEOrientationEventListener$SensorEventListenerImpl
  implements SensorEventListener
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float[] arrayOfFloat = paramSensorEvent.values;
    float f1 = -arrayOfFloat[0];
    float f2 = -arrayOfFloat[1];
    float f3 = -arrayOfFloat[2];
    if ((f1 * f1 + f2 * f2) * 35 >= f3 * f3)
    {
      float f4;
      for (int i = 90 - Math.round((float)Math.atan2(-f2, f1) * 57.29578F);; i = (int)(f4 - 360.0F))
      {
        f4 = i;
        if (f4 < 360.0F) {
          break;
        }
      }
      for (;;)
      {
        j = i;
        if (i >= 0) {
          break;
        }
        i = (int)(i + 360.0F);
      }
    }
    int j = -1;
    if (AEOrientationEventListener.a(this.a) != null) {
      AEOrientationEventListener.a(this.a).onSensorChanged(1, paramSensorEvent.values);
    }
    if (j != AEOrientationEventListener.b(this.a))
    {
      AEOrientationEventListener.a(this.a, j);
      this.a.a(j);
    }
    this.a.a((f1 + 9.8F) * 180.0F / 19.6F, (f2 + 9.8F) * 180.0F / 19.6F, (f3 + 9.8F) * 180.0F / 19.6F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.AEOrientationEventListener.SensorEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */