package com.tencent.mobileqq.vashealth;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.qphone.base.util.QLog;

class HealthStepCounterPlugin$StepShakeListener
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private float b;
  private float c;
  private float d;
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Float = 0.0F;
    this.b = 0.0F;
    this.c = 0.0F;
    this.d = 0.0F;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    HealthStepCounterPlugin.b = 1;
    HealthStepCounterPlugin.a = true;
  }
  
  public void b()
  {
    HealthStepCounterPlugin.b = 3;
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
      long l2 = l1 - this.jdField_a_of_type_Long;
      if (l2 > 5000L)
      {
        a(l1);
        return;
      }
      if (l2 > 80L)
      {
        float f5 = this.jdField_a_of_type_Float;
        float f1 = 0.0F;
        if ((f5 != 0.0F) || (this.b != 0.0F) || (this.c != 0.0F))
        {
          f1 = Math.abs(f2 - this.jdField_a_of_type_Float);
          f5 = Math.abs(f3 - this.b);
          f1 = Math.abs(f4 - this.c) + (f1 + f5);
        }
        this.d += f1;
        if ((this.d > 180.0F) && (this.jdField_a_of_type_Int >= 3))
        {
          a();
          a(l1);
          return;
        }
        int i = this.jdField_a_of_type_Int;
        if (i < 10)
        {
          this.jdField_a_of_type_Int = (i + 1);
          this.jdField_a_of_type_Float = f2;
          this.b = f3;
          this.c = f4;
          this.jdField_a_of_type_Long = l1;
          return;
        }
        a(l1);
        if (HealthStepCounterPlugin.b < 3) {
          b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.StepShakeListener
 * JD-Core Version:    0.7.0.1
 */