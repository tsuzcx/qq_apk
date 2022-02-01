package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import mqq.app.AppRuntime;

class ContactImpl$1
  implements Runnable
{
  ContactImpl$1(ContactImpl paramContactImpl, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ((IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "")).uploadPhoneContact();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ContactImpl.1
 * JD-Core Version:    0.7.0.1
 */