package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class LoginUserGuideHelper$1$1
  implements Runnable
{
  LoginUserGuideHelper$1$1(LoginUserGuideHelper.1 param1) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.this$0.a.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.1.1
 * JD-Core Version:    0.7.0.1
 */