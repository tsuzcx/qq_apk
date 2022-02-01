package com.tencent.mobileqq.servlet;

import bcvr;
import bcvs;
import com.tencent.qphone.base.util.QLog;

public class QZoneManagerImp$1$1
  implements Runnable
{
  public QZoneManagerImp$1$1(bcvs parambcvs) {}
  
  public void run()
  {
    long l = bcvr.a(this.a.a);
    bcvr.a(this.a.a);
    bcvr.a(this.a.a, bcvr.b(this.a.a));
    this.a.a.a(l | bcvr.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(bcvr.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */