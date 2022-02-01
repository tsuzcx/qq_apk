package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.PhoneContactManager;
import mqq.app.AppRuntime;

class ContactImpl$1
  implements Runnable
{
  ContactImpl$1(ContactImpl paramContactImpl, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ((PhoneContactManager)this.a.getManager(QQManagerFactory.CONTACT_MANAGER)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ContactImpl.1
 * JD-Core Version:    0.7.0.1
 */