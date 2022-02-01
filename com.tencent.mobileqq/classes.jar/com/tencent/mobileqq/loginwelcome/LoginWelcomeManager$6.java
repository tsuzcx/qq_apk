package com.tencent.mobileqq.loginwelcome;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.data.RecommendedListResp;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver2;
import com.tencent.qphone.base.util.QLog;

class LoginWelcomeManager$6
  extends ContactBindObserver2
{
  LoginWelcomeManager$6(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void a(RecommendedListResp paramRecommendedListResp)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onGetRecommendedList resp=%s", new Object[] { paramRecommendedListResp }));
      }
      if (LoginWelcomeManager.a(this.a) != null)
      {
        Bundle localBundle = LoginWelcomeManager.a(this.a).getBundle("request");
        if (localBundle != null) {
          localBundle.putParcelable("result", paramRecommendedListResp);
        }
        this.a.b();
      }
      LoginWelcomeManager.a(this.a).removeObserver(LoginWelcomeManager.a(this.a));
      return;
    }
    catch (Throwable paramRecommendedListResp)
    {
      QLog.e("LoginWelcomeManager", 1, "onGetRecommendedList fail.", paramRecommendedListResp);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("ShowCommonGuideWebResult result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.6
 * JD-Core Version:    0.7.0.1
 */