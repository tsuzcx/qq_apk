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
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQLSSensor onSensorChanged");
      localStringBuilder.append(???.values[0]);
      QLog.d("QQLSSensor", 4, localStringBuilder.toString());
    }
    if (QQLSSensor.a(this.a) == null) {
      return;
    }
    if (DeviceInfoUtil.W())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < QQLSSensor.b(this.a)) {
      QQLSSensor.a(this.a, true);
    } else {
      QQLSSensor.a(this.a, false);
    }
    ??? = Build.MODEL;
    if (DeviceInfoUtil.V())
    {
      if (QQLSSensor.c(this.a).hasMessages(1)) {
        QQLSSensor.c(this.a).removeMessages(1);
      }
      QQLSSensor.c(this.a).sendMessageDelayed(QQLSSensor.c(this.a).obtainMessage(1), 150L);
      return;
    }
    if ((!???.equalsIgnoreCase("mi 3c")) && (!???.equalsIgnoreCase("K-Touch W619")) && (!???.equalsIgnoreCase("mi 3w"))) {
      synchronized (this.a)
      {
        if (QQLSSensor.a(this.a) != null) {
          QQLSSensor.a(this.a).a(QQLSSensor.d(this.a));
        }
        return;
      }
    }
    if (QQLSSensor.c(this.a).hasMessages(1)) {
      QQLSSensor.c(this.a).removeMessages(1);
    }
    QQLSSensor.c(this.a).sendMessageDelayed(QQLSSensor.c(this.a).obtainMessage(1), 250L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQLSSensor.1
 * JD-Core Version:    0.7.0.1
 */