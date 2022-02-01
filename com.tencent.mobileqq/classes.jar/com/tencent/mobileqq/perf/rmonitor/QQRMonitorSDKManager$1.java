package com.tencent.mobileqq.perf.rmonitor;

import com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class QQRMonitorSDKManager$1
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRMonitorSDKManager", 2, "start init runnable ");
    }
    QQRMonitorSDKManager.a();
    if ((QQRMonitorSDKManager.a != null) && (QQRMonitorSDKManager.a.a))
    {
      QQRMonitorSDKManager.b();
      QQRMonitorSDKManager.c();
      QQRMonitorSDKManager.d();
      QQRMonitorSDKManager.e();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRMonitorSDKManager", 2, "mainSwitch is not opened.");
    }
    QQRMonitorSDKManager.f().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager.1
 * JD-Core Version:    0.7.0.1
 */