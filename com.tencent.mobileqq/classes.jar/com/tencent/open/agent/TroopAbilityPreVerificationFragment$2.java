package com.tencent.open.agent;

import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class TroopAbilityPreVerificationFragment$2
  extends OpenIdObserver
{
  TroopAbilityPreVerificationFragment$2(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  public void a(boolean paramBoolean, OpenID paramOpenID)
  {
    QLog.d("TroopAbility.PreVerification", 1, "-->onGetOpenId, isSuccess: " + paramBoolean + " data: " + paramOpenID);
    if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
    {
      if (!paramOpenID.openID.equals(this.a.b))
      {
        this.a.d();
        TroopAbilityPreVerificationFragment.a(this.a);
        return;
      }
      this.a.c();
      return;
    }
    this.a.c(HardCodeUtil.a(2131714988));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityPreVerificationFragment.2
 * JD-Core Version:    0.7.0.1
 */