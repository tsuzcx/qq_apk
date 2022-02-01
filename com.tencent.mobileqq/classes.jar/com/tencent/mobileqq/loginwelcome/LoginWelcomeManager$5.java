package com.tencent.mobileqq.loginwelcome;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

class LoginWelcomeManager$5
  extends ProfileCardObserver
{
  LoginWelcomeManager$5(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onCardDownload isSuccess=%s data=%s", new Object[] { Boolean.valueOf(paramBoolean), paramObject }));
    }
    if (LoginWelcomeManager.a(this.a) != null)
    {
      if ((paramBoolean) && (paramObject != null)) {
        try
        {
          Object localObject = LoginWelcomeManager.a(this.a).getBundle("request");
          String str = ((Bundle)localObject).getString("uin");
          long l1 = Long.parseLong(LoginWelcomeManager.a(this.a).getCurrentAccountUin());
          long l2 = Long.parseLong(str);
          localObject = ((Bundle)localObject).getString("authSig");
          LoginWelcomeManager.a(this.a).addObserver(this.a.a);
          ITroopMngHandler localITroopMngHandler = (ITroopMngHandler)LoginWelcomeManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
          paramObject = TroopUtils.a(LoginWelcomeManager.a(this.a), (Card)paramObject);
          localITroopMngHandler.a(str, paramObject, 1, null, (String)localObject, TroopUtils.a(LoginWelcomeManager.a(this.a), paramObject, l1, l2), null);
        }
        catch (Exception paramObject)
        {
          QLog.e("LoginWelcomeManager", 1, "onCardDownload fail.", paramObject);
        }
      } else {
        this.a.b();
      }
      LoginWelcomeManager.a(this.a).removeObserver(LoginWelcomeManager.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.5
 * JD-Core Version:    0.7.0.1
 */