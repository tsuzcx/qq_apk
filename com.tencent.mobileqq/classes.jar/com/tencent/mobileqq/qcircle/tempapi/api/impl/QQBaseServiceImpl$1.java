package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

class QQBaseServiceImpl$1
  extends LoginVerifyObserver
{
  QQBaseServiceImpl$1(QQBaseServiceImpl paramQQBaseServiceImpl, AccountIdentityCallBack paramAccountIdentityCallBack) {}
  
  public void a(cmd0x9ae.RspBody paramRspBody)
  {
    if (paramRspBody != null)
    {
      boolean bool = paramRspBody.bool_has_been_authenticated.get();
      paramRspBody = paramRspBody.msg_auth_tips.string_tips_action_url.get();
      this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiInterfacesAccountIdentityCallBack.onSuccess(bool, paramRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QQBaseServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */