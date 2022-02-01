package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class ForwardSdkShareOption$8
  extends OpenIdObserver
{
  ForwardSdkShareOption$8(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (!this.a.s.isFinishing())
    {
      if (this.a.ah) {
        return;
      }
      this.a.ae();
      if (this.a.ag != null) {
        this.a.ag.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(this.a.ad))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->onGetOpenId--openid doesn't equal current openid");
          }
          this.a.aG();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver fail");
      }
      if (ForwardSdkShareOption.b(this.a))
      {
        this.a.t.putString("uin", "-1010");
        this.a.t.putInt("uintype", -1);
        this.a.t.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.f.intValue());
        this.a.I();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.8
 * JD-Core Version:    0.7.0.1
 */