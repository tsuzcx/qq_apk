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
    if (DeviceInfoUtil.j())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < QQLSSensor.a(this.a)) {
      QQLSSensor.a(this.a, true);
    } else {
      QQLSSensor.a(this.a, false);
    }
    ??? = Build.MODEL;
    if (DeviceInfoUtil.i())
    {
      if (QQLSSensor.a(this.a).hasMessages(1)) {
        QQLSSensor.a(this.a).removeMessages(1);
      }
      QQLSSensor.a(this.a).sendMessageDelayed(QQLSSensor.a(this.a).obtainMessage(1), 150L);
      return;
    }
    if ((!???.equalsIgnoreCase("mi 3c")) && (!???.equalsIgnoreCase("K-Touch W619")) && (!???.equalsIgnoreCase("mi 3w"))) {
      synchronized (this.a)
      {
        if (QQLSSensor.a(this.a) != null) {
          QQLSSensor.a(this.a).a(QQLSSensor.a(this.a));
        }
        return;
      }
    }
    if (QQLSSensor.a(this.a).hasMessages(1)) {
      QQLSSensor.a(this.a).removeMessages(1);
    }
    QQLSSensor.a(this.a).sendMessageDelayed(QQLSSensor.a(this.a).obtainMessage(1), 250L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQLSSensor.1
 * JD-Core Version:    0.7.0.1
 */