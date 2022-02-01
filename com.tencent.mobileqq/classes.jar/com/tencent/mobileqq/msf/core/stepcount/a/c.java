package com.tencent.mobileqq.msf.core.stepcount.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class c
  implements SensorEventListener2
{
  c(b paramb) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onFlushCompleted(Sensor paramSensor)
  {
    b.a(this.a).a();
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent != null) && (paramSensorEvent.values != null) && (paramSensorEvent.values.length != 0))
    {
      long l = NetConnInfoCenter.getServerTime();
      int i = (int)paramSensorEvent.values[0];
      b.a(this.a, i, l);
      if (((Integer)b.a(this.a).b().second).intValue() != i) {
        b.b(this.a);
      }
      b.a(this.a).a(i, l);
      return;
    }
    QLog.d("StepEventHandlerImpl", 1, "sensor value is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.stepcount.a.c
 * JD-Core Version:    0.7.0.1
 */