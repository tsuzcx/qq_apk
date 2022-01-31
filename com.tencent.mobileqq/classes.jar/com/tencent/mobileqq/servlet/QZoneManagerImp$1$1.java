package com.tencent.mobileqq.servlet;

import awcz;
import awda;
import com.tencent.qphone.base.util.QLog;

public class QZoneManagerImp$1$1
  implements Runnable
{
  public QZoneManagerImp$1$1(awda paramawda) {}
  
  public void run()
  {
    long l = awcz.a(this.a.a);
    awcz.a(this.a.a);
    awcz.a(this.a.a, awcz.b(this.a.a));
    this.a.a.a(l | awcz.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(awcz.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */