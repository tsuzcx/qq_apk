package com.tencent.mobileqq.servlet;

import axcj;
import axck;
import com.tencent.qphone.base.util.QLog;

public class QZoneManagerImp$1$1
  implements Runnable
{
  public QZoneManagerImp$1$1(axck paramaxck) {}
  
  public void run()
  {
    long l = axcj.a(this.a.a);
    axcj.a(this.a.a);
    axcj.a(this.a.a, axcj.b(this.a.a));
    this.a.a.a(l | axcj.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(axcj.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */