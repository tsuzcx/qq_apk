package com.tencent.mobileqq.servlet;

import bcvn;
import bcvo;
import com.tencent.qphone.base.util.QLog;

public class QZoneManagerImp$1$1
  implements Runnable
{
  public QZoneManagerImp$1$1(bcvo parambcvo) {}
  
  public void run()
  {
    long l = bcvn.a(this.a.a);
    bcvn.a(this.a.a);
    bcvn.a(this.a.a, bcvn.b(this.a.a));
    this.a.a.a(l | bcvn.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(bcvn.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */