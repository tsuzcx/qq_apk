package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.weather.WeatherObserver;
import mqq.app.AppRuntime.Status;

class AccountPanel$19
  extends WeatherObserver
{
  AccountPanel$19(AccountPanel paramAccountPanel) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    paramBundle = AccountPanel.a(this.a).getOnlineStatus();
    long l = OnLineStatusHelper.a().a(AccountPanel.a(this.a));
    if ((paramBoolean) && (paramBundle == AppRuntime.Status.online) && (l == 1030L))
    {
      if (AccountPanel.a(this.a) != null) {
        AccountPanel.a(this.a).a(paramBundle);
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.19
 * JD-Core Version:    0.7.0.1
 */