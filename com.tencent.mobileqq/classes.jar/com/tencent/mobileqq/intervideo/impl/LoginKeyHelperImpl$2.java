package com.tencent.mobileqq.intervideo.impl;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.GetLoginKeyListener;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;

class LoginKeyHelperImpl$2
  implements OpensdkBusinessObserver
{
  LoginKeyHelperImpl$2(LoginKeyHelperImpl paramLoginKeyHelperImpl, ILoginKeyHelper.GetLoginKeyListener paramGetLoginKeyListener, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    new Bundle();
    paramBundle = paramBundle.getByteArray("data");
    if (paramBundle == null)
    {
      this.a.onGetKeyComplete(this.b, false, -10002);
      return;
    }
    FastAuthorize.AuthorizeResponse localAuthorizeResponse = new FastAuthorize.AuthorizeResponse();
    try
    {
      localAuthorizeResponse.mergeFrom(paramBundle);
      if ((localAuthorizeResponse.ret.get().equals("0")) && (localAuthorizeResponse.apk_name.has()))
      {
        if (localAuthorizeResponse.access_token.has()) {
          this.c.mAccountInfo.a = localAuthorizeResponse.access_token.get();
        }
        if (localAuthorizeResponse.openid.has()) {
          this.c.mAccountInfo.b = localAuthorizeResponse.openid.get();
        }
        if (localAuthorizeResponse.pay_token.has()) {
          this.c.mAccountInfo.c = localAuthorizeResponse.pay_token.get();
        }
        this.c.mAccountInfo.e = System.currentTimeMillis();
        this.a.onGetKeyComplete(this.b, true, 0);
        return;
      }
      QLog.e("XProxy", 2, "获取票据失败");
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label230:
      this.a.onGetKeyComplete(this.b, false, -10003);
      paramBundle.printStackTrace();
      return;
    }
    try
    {
      this.a.onGetKeyComplete(this.b, false, Integer.parseInt(localAuthorizeResponse.ret.get()));
      return;
    }
    catch (NumberFormatException paramBundle)
    {
      break label230;
    }
    this.a.onGetKeyComplete(this.b, false, 0);
    QLog.e("XProxy", 2, "获取票据错误码不为int");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.impl.LoginKeyHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */