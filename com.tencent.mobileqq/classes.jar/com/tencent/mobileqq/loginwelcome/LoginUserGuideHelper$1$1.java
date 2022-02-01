package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class LoginUserGuideHelper$1$1
  implements Runnable
{
  LoginUserGuideHelper$1$1(LoginUserGuideHelper.1 param1) {}
  
  public void run()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.this$0.a.getRuntimeService(IPhoneContactService.class, "");
    if (localIPhoneContactService != null) {
      localIPhoneContactService.uploadOrUpdateContact();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.1.1
 * JD-Core Version:    0.7.0.1
 */