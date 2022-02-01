package com.tencent.mobileqq.loginwelcome;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class LoginWelcomeManager$2
  extends TroopMngObserver
{
  LoginWelcomeManager$2(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onTroopManagerFailed result=%s", new Object[] { Integer.valueOf(paramInt2) }));
    }
    if (1 == paramInt1) {
      QQToast.makeText(LoginWelcomeManager.b(this.a).getApp(), 4, 2131915702, 1).show();
    }
    LoginWelcomeManager.b(this.a).removeObserver(this);
    this.a.b();
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("LoginWelcomeManager", 2, String.format("onTroopManagerSuccess result=%s troopUin=%s", new Object[] { Integer.valueOf(paramInt2), paramString }));
    }
    if (1 == paramInt1)
    {
      QQToast.makeText(LoginWelcomeManager.b(this.a).getApp(), 5, 2131915703, 1).show();
      Bundle localBundle = LoginWelcomeManager.a(this.a).getBundle("request");
      localBundle.putString("uin", String.valueOf(paramString));
      paramInt1 = i;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      }
      localBundle.putInt("result", paramInt1);
    }
    LoginWelcomeManager.b(this.a).removeObserver(this);
    this.a.b();
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean)
    {
      Bundle localBundle = LoginWelcomeManager.a(this.a).getBundle("request");
      localBundle.putString("uin", String.valueOf(paramLong));
      localBundle.putShort("option", paramTroopInfo.cGroupOption);
      localBundle.putString("name", paramTroopInfo.troopname);
      if ((paramTroopInfo.cGroupOption != 4) && (paramTroopInfo.cGroupOption != 5))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, "onSend0x88d_1_forJoinTroop_Ret err");
        }
      }
      else
      {
        localBundle.putString("answer", paramTroopInfo.joinTroopAnswer);
        localBundle.putString("question", paramTroopInfo.joinTroopQuestion);
      }
    }
    this.a.b();
    LoginWelcomeManager.b(this.a).removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.2
 * JD-Core Version:    0.7.0.1
 */