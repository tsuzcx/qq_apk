package com.tencent.open.agent;

import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;

class JoinTroopPreVerificationFragment$1
  extends TroopObserver
{
  JoinTroopPreVerificationFragment$1(JoinTroopPreVerificationFragment paramJoinTroopPreVerificationFragment) {}
  
  protected void onGetJoinTroopTokenForThirdApp(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.a.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetJoinTroopTokenForThirdApp, isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" token: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", troopUin: ");
    localStringBuilder.append(paramString2);
    QLog.i("TroopAbility.PreVerification", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      paramString2 = TroopInfoUIUtil.a(String.valueOf(paramString2), 32);
      paramString2.putString("authSig", paramString1);
      paramString2.putString("appid", this.a.h);
      paramString2.putBoolean("fromThirdAppByOpenSDK", true);
      paramString2.putInt("action", 3);
      paramString2.putString("pkg_name", this.a.i);
      paramString2.putString("app_name", this.a.f);
      TroopUtils.a(this.a.b, paramString2, 2);
      this.a.b.finish();
      return;
    }
    this.a.a(HardCodeUtil.a(2131903835));
    this.a.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.JoinTroopPreVerificationFragment.1
 * JD-Core Version:    0.7.0.1
 */