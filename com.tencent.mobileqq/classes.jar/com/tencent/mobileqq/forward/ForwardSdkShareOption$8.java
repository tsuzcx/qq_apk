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
    if (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if (this.a.k) {
        return;
      }
      this.a.A();
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(this.a.h))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->onGetOpenId--openid doesn't equal current openid");
          }
          this.a.N();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver fail");
      }
      if (ForwardSdkShareOption.a(this.a))
      {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("uin", "-1010");
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.e.intValue());
        this.a.n();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.8
 * JD-Core Version:    0.7.0.1
 */