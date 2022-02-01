package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class LoginUserGuideHelper$GuideRunnable$1
  implements Runnable
{
  LoginUserGuideHelper$GuideRunnable$1(LoginUserGuideHelper.GuideRunnable paramGuideRunnable, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "");
    if (localIPhoneContactService != null) {
      localIPhoneContactService.markAndUploadForNewGuide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.GuideRunnable.1
 * JD-Core Version:    0.7.0.1
 */