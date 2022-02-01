package com.tencent.mobileqq.onlinestatus.auto.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;

public class StepSensorCounter
  extends StepMovementDetector
{
  private boolean i = false;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private long m = 0L;
  
  @RequiresApi(api=19)
  StepSensorCounter()
  {
    super(19);
    this.a = "StepSensorCounter";
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int n = (int)paramSensorEvent.values[0];
    if (!this.i)
    {
      this.i = true;
      this.j = n;
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, new Object[] { "[status][step] initRecord hasStepCount:", Integer.valueOf(this.j) });
      }
    }
    else
    {
      n -= this.j;
      int i1 = n - this.k;
      int i2 = this.l;
      if (i2 == 0)
      {
        this.m = System.currentTimeMillis();
        this.l = 1;
      }
      else
      {
        this.l = (i2 + i1);
      }
      a(i1);
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, new Object[] { "[status][step] thisStepCount:", Integer.valueOf(n), " thisStep:", Integer.valueOf(i1), " sampleStepCount:", Integer.valueOf(this.l) });
      }
      this.k = n;
      if (this.l >= Constant.C)
      {
        long l1 = System.currentTimeMillis() - this.m;
        if (l1 > 0L)
        {
          n = this.l;
          if (n > 0) {
            a(l1 / n);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, new Object[] { "[status][step] duration:", Long.valueOf(l1), " sampleStepStartTime:", Long.valueOf(this.m) });
        }
        this.l = 0;
        this.m = 0L;
      }
      this.c = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.StepSensorCounter
 * JD-Core Version:    0.7.0.1
 */