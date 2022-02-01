package com.tencent.mobileqq.loginwelcome;

import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class LoginwelcomeHelper$1
  implements LoginWelcomeManager.ConvListener
{
  LoginwelcomeHelper$1(LoginwelcomeHelper paramLoginwelcomeHelper) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowContactsGuideLayer");
    }
    if (LoginwelcomeHelper.a(this.a) != null) {
      LoginwelcomeHelper.a(this.a).post(new LoginwelcomeHelper.1.1(this, paramURLDrawable));
    }
  }
  
  public void a(LoginWelcomeManager.CommonGuideInfo paramCommonGuideInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onShowCommonGuideWeb");
    }
    LoginwelcomeHelper.a(this.a, paramCommonGuideInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.1
 * JD-Core Version:    0.7.0.1
 */