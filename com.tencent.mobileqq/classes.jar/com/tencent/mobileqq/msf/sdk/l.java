package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.util.QLog;

class l
  extends Thread
{
  l(k paramk) {}
  
  public void run()
  {
    c.a().onServiceConnected();
    int i = this.a.registerMsfService(false, true);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, " registerMsfService result:" + i);
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.l
 * JD-Core Version:    0.7.0.1
 */