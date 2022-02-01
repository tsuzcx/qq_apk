package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class LoginUserGuideHelper$GuideRunnable$1
  implements Runnable
{
  LoginUserGuideHelper$GuideRunnable$1(LoginUserGuideHelper.GuideRunnable paramGuideRunnable, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.GuideRunnable.1
 * JD-Core Version:    0.7.0.1
 */