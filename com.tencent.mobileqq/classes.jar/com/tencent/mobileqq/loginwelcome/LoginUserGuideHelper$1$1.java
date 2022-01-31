package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class LoginUserGuideHelper$1$1
  implements Runnable
{
  LoginUserGuideHelper$1$1(LoginUserGuideHelper.1 param1) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.this$0.a.getManager(11);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.1.1
 * JD-Core Version:    0.7.0.1
 */