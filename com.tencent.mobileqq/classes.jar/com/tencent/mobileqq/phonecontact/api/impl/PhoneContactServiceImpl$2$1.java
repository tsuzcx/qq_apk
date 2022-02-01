package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.qphone.base.util.QLog;

class PhoneContactServiceImpl$2$1
  implements Runnable
{
  PhoneContactServiceImpl$2$1(PhoneContactServiceImpl.2 param2) {}
  
  public void run()
  {
    if (PhoneContactServiceImpl.access$400(this.a.a)) {
      return;
    }
    PhoneContactServiceImpl.access$802(this.a.a, false);
    if (this.a.a.getSelfBindState() <= 5) {
      try
      {
        this.a.b();
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("IMCore.PhoneContact.PhoneContactServiceImpl", 1, "onFirstRespQueryNotBindState fail!", localException1);
        return;
      }
    }
    try
    {
      this.a.c();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("IMCore.PhoneContact.PhoneContactServiceImpl", 1, "onFirstRespQueryState fail!", localException2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.2.1
 * JD-Core Version:    0.7.0.1
 */