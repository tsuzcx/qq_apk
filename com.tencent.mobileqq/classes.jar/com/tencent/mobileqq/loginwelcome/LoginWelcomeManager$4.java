package com.tencent.mobileqq.loginwelcome;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class LoginWelcomeManager$4
  extends CardObserver
{
  LoginWelcomeManager$4(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  public void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    paramInt = 1;
    QLog.d("LoginWelcomeManager", 1, String.format("mCardObserver.onUpdateAvatar isSuccess=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    if (TextUtils.equals(LoginWelcomeManager.a(this.a).getCurrentAccountUin(), paramString)) {
      if (LoginWelcomeManager.a(this.a) != null)
      {
        paramString = LoginWelcomeManager.a(this.a).getBundle("request");
        if (paramString != null) {
          if (!paramBoolean) {
            break label130;
          }
        }
      }
    }
    for (;;)
    {
      paramString.putInt("result", paramInt);
      paramString.putString("path", LoginWelcomeManager.a(this.a));
      LoginWelcomeManager.a(this.a, null);
      this.a.b();
      LoginWelcomeManager.a(this.a).removeObserver(LoginWelcomeManager.a(this.a));
      return;
      label130:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.4
 * JD-Core Version:    0.7.0.1
 */