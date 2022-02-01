package com.tencent.mobileqq.servlet;

import bbox;
import bboy;
import com.tencent.qphone.base.util.QLog;

public class QZoneManagerImp$1$1
  implements Runnable
{
  public QZoneManagerImp$1$1(bboy parambboy) {}
  
  public void run()
  {
    long l = bbox.a(this.a.a);
    bbox.a(this.a.a);
    bbox.a(this.a.a, bbox.b(this.a.a));
    this.a.a.a(l | bbox.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(bbox.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */