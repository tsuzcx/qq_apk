package com.tencent.mobileqq.loginwelcome;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;

class LoginWelcomeManager$5
  extends ProfileCardObserver
{
  LoginWelcomeManager$5(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onCardDownload isSuccess=%s data=%s", new Object[] { Boolean.valueOf(paramBoolean), paramObject }));
    }
    if ((LoginWelcomeManager.a(this.a) == null) || ((paramBoolean) && (paramObject != null))) {}
    for (;;)
    {
      try
      {
        Object localObject = LoginWelcomeManager.a(this.a).getBundle("request");
        String str = ((Bundle)localObject).getString("uin");
        long l1 = Long.parseLong(LoginWelcomeManager.a(this.a).getCurrentAccountUin());
        long l2 = Long.parseLong(str);
        localObject = ((Bundle)localObject).getString("authSig");
        LoginWelcomeManager.a(this.a).addObserver(this.a.a);
        TroopHandler localTroopHandler = (TroopHandler)LoginWelcomeManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        paramObject = localTroopHandler.a((Card)paramObject);
        localTroopHandler.a(str, paramObject, 1, null, (String)localObject, localTroopHandler.a(paramObject, l1, l2), null);
        LoginWelcomeManager.a(this.a).removeObserver(LoginWelcomeManager.a(this.a));
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("LoginWelcomeManager", 1, "onCardDownload fail.", paramObject);
        continue;
      }
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.5
 * JD-Core Version:    0.7.0.1
 */