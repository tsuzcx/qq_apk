package com.tencent.mobileqq.flashshow.helper;

import com.tencent.mobileqq.flashshow.callback.AccountIdentityCallBack;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

final class FSStaticInvokeHelper$1
  extends LoginVerifyObserver
{
  FSStaticInvokeHelper$1(AccountIdentityCallBack paramAccountIdentityCallBack) {}
  
  public void getAccountIdentitySuccess(cmd0x9ae.RspBody paramRspBody)
  {
    if (paramRspBody != null)
    {
      boolean bool = paramRspBody.bool_has_been_authenticated.get();
      paramRspBody = paramRspBody.msg_auth_tips.string_tips_action_url.get();
      this.val$callBack.onSuccess(bool, paramRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSStaticInvokeHelper.1
 * JD-Core Version:    0.7.0.1
 */