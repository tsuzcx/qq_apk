package com.tencent.mobileqq.servlet;

import ayxn;
import ayxo;
import com.tencent.qphone.base.util.QLog;

public class QZoneManagerImp$1$1
  implements Runnable
{
  public QZoneManagerImp$1$1(ayxo paramayxo) {}
  
  public void run()
  {
    long l = ayxn.a(this.a.a);
    ayxn.a(this.a.a);
    ayxn.a(this.a.a, ayxn.b(this.a.a));
    this.a.a.a(l | ayxn.a(this.a.a));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(ayxn.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */