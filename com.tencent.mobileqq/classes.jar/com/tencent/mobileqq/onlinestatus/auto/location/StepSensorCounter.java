package com.tencent.mobileqq.onlinestatus.auto.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;

public class StepSensorCounter
  extends StepMovementDetector
{
  private boolean a;
  private long c = 0L;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  
  @RequiresApi(api=19)
  StepSensorCounter()
  {
    super(19);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "StepSensorCounter";
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = (int)paramSensorEvent.values[0];
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.d = i;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] initRecord hasStepCount:", Integer.valueOf(this.d) });
      }
    }
    else
    {
      i -= this.d;
      int j = i - this.e;
      int k = this.f;
      if (k == 0)
      {
        this.c = System.currentTimeMillis();
        this.f = 1;
      }
      else
      {
        this.f = (k + j);
      }
      a(j);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] thisStepCount:", Integer.valueOf(i), " thisStep:", Integer.valueOf(j), " sampleStepCount:", Integer.valueOf(this.f) });
      }
      this.e = i;
      if (this.f >= Constant.B)
      {
        long l = System.currentTimeMillis() - this.c;
        if (l > 0L)
        {
          i = this.f;
          if (i > 0) {
            a(l / i);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] duration:", Long.valueOf(l), " sampleStepStartTime:", Long.valueOf(this.c) });
        }
        this.f = 0;
        this.c = 0L;
      }
      this.jdField_a_of_type_Double = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.StepSensorCounter
 * JD-Core Version:    0.7.0.1
 */