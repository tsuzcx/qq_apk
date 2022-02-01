package com.tencent.open.agent;

import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class TroopAbilityPreVerificationFragment$2
  extends OpenIdObserver
{
  TroopAbilityPreVerificationFragment$2(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->onGetOpenId, isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" data: ");
    localStringBuilder.append(paramOpenID);
    QLog.d("TroopAbility.PreVerification", 1, localStringBuilder.toString());
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
    this.a.c(HardCodeUtil.a(2131714911));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityPreVerificationFragment.2
 * JD-Core Version:    0.7.0.1
 */