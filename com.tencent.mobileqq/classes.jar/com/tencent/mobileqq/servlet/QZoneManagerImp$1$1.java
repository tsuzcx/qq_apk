package com.tencent.mobileqq.servlet;

import axch;
import axci;
import com.tencent.qphone.base.util.QLog;

public class QZoneManagerImp$1$1
  implements Runnable
{
  public QZoneManagerImp$1$1(axci paramaxci) {}
  
  public void run()
  {
    long l = axch.a(this.a.a);
    axch.a(this.a.a);
    axch.a(this.a.a, axch.b(this.a.a));
    this.a.a.a(l | axch.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(axch.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */