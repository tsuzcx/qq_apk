package com.tencent.mobileqq.servlet;

import bccv;
import bccw;
import com.tencent.qphone.base.util.QLog;

public class QZoneManagerImp$1$1
  implements Runnable
{
  public QZoneManagerImp$1$1(bccw parambccw) {}
  
  public void run()
  {
    long l = bccv.a(this.a.a);
    bccv.a(this.a.a);
    bccv.a(this.a.a, bccv.b(this.a.a));
    this.a.a.a(l | bccv.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(bccv.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */