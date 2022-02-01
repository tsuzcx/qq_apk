package com.tencent.mobileqq.vashealth;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.qphone.base.util.QLog;

class HealthStepCounterPlugin$StepShakeListener
  implements SensorEventListener
{
  private long a;
  private float b;
  private float c;
  private float d;
  private float e;
  private int f = 0;
  
  private void a(long paramLong)
  {
    this.a = paramLong;
    this.b = 0.0F;
    this.c = 0.0F;
    this.d = 0.0F;
    this.e = 0.0F;
    this.f = 0;
  }
  
  public void a()
  {
    HealthStepCounterPlugin.n = 1;
    HealthStepCounterPlugin.o = true;
  }
  
  public void b()
  {
    HealthStepCounterPlugin.n = 3;
    QLog.d("HealthStepCounterPlugin", 1, "shaking end");
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
    {
      float f2 = paramSensorEvent.values[0];
      float f3 = paramSensorEvent.values[1];
      float f4 = paramSensorEvent.values[2];
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.a;
      if (l2 > 5000L)
      {
        a(l1);
        return;
      }
      if (l2 > 80L)
      {
        float f5 = this.b;
        float f1 = 0.0F;
        if ((f5 != 0.0F) || (this.c != 0.0F) || (this.d != 0.0F))
        {
          f1 = Math.abs(f2 - this.b);
          f5 = Math.abs(f3 - this.c);
          f1 = Math.abs(f4 - this.d) + (f1 + f5);
        }
        this.e += f1;
        if ((this.e > 180.0F) && (this.f >= 3))
        {
          a();
          a(l1);
          return;
        }
        int i = this.f;
        if (i < 10)
        {
          this.f = (i + 1);
          this.b = f2;
          this.c = f3;
          this.d = f4;
          this.a = l1;
          return;
        }
        a(l1);
        if (HealthStepCounterPlugin.n < 3) {
          b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.StepShakeListener
 * JD-Core Version:    0.7.0.1
 */