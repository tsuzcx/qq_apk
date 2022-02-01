package com.tencent.mobileqq.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class QQLSSensor$1
  implements SensorEventListener
{
  QQLSSensor$1(QQLSSensor paramQQLSSensor) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (QQLSSensor.a(this.a) == null) {
      return;
    }
    if (DeviceInfoUtil.h())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < QQLSSensor.a(this.a)) {
      QQLSSensor.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!DeviceInfoUtil.g()) {
        break;
      }
      if (QQLSSensor.a(this.a).hasMessages(1)) {
        QQLSSensor.a(this.a).removeMessages(1);
      }
      QQLSSensor.a(this.a).sendMessageDelayed(QQLSSensor.a(this.a).obtainMessage(1), 150L);
      return;
      QQLSSensor.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (QQLSSensor.a(this.a).hasMessages(1)) {
        QQLSSensor.a(this.a).removeMessages(1);
      }
      QQLSSensor.a(this.a).sendMessageDelayed(QQLSSensor.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (QQLSSensor.a(this.a) != null) {
        QQLSSensor.a(this.a).a(QQLSSensor.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQLSSensor.1
 * JD-Core Version:    0.7.0.1
 */