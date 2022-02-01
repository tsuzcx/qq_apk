package com.tencent.mobileqq.servlet;

import com.tencent.qphone.base.util.QLog;

class QZoneManagerImp$1$1
  implements Runnable
{
  QZoneManagerImp$1$1(QZoneManagerImp.1 param1) {}
  
  public void run()
  {
    long l = QZoneManagerImp.a(this.a.a);
    QZoneManagerImp.a(this.a.a);
    QZoneManagerImp.a(this.a.a, QZoneManagerImp.b(this.a.a));
    this.a.a.a(l | QZoneManagerImp.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(QZoneManagerImp.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */