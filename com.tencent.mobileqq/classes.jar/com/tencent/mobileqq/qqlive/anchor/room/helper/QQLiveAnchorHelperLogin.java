package com.tencent.mobileqq.qqlive.anchor.room.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.qphone.base.util.QLog;

public class QQLiveAnchorHelperLogin
{
  public boolean a = false;
  
  private void a(int paramInt, String paramString, QQLiveAnchorHelperLogin.Callback paramCallback)
  {
    this.a = false;
    QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
    localQQLiveErrorMsg.bizModule = 2;
    localQQLiveErrorMsg.bizErrCode = 6100;
    localQQLiveErrorMsg.bizErrMsg = "init login err";
    localQQLiveErrorMsg.originErrCode = paramInt;
    localQQLiveErrorMsg.originErrMsg = paramString;
    paramCallback.a(localQQLiveErrorMsg);
  }
  
  private void a(LoginInfo paramLoginInfo, QQLiveAnchorHelperLogin.Callback paramCallback)
  {
    this.a = true;
    paramCallback.a(paramLoginInfo);
  }
  
  private void a(String paramString, QQLiveAnchorHelperLogin.Callback paramCallback)
  {
    this.a = false;
    QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
    localQQLiveErrorMsg.bizModule = 2;
    localQQLiveErrorMsg.bizErrCode = 6100;
    localQQLiveErrorMsg.bizErrMsg = paramString;
    paramCallback.a(localQQLiveErrorMsg);
  }
  
  public void a(@NonNull IQQLiveSDK paramIQQLiveSDK, @NonNull QQLiveAnchorHelperLogin.Callback paramCallback)
  {
    if ((paramIQQLiveSDK != null) && (paramCallback != null))
    {
      this.a = false;
      paramIQQLiveSDK = paramIQQLiveSDK.getLoginModule();
      if (paramIQQLiveSDK == null)
      {
        a("loginModule is null", paramCallback);
        return;
      }
      if (!paramIQQLiveSDK.isLogined())
      {
        LoginRequest localLoginRequest = paramIQQLiveSDK.getLoginRequest();
        if (localLoginRequest == null)
        {
          a("loginRequst is null", paramCallback);
          return;
        }
        paramIQQLiveSDK.login(localLoginRequest, new QQLiveAnchorHelperLogin.1(this, paramCallback));
        return;
      }
      paramIQQLiveSDK = paramIQQLiveSDK.getLoginInfo();
      if (paramIQQLiveSDK == null)
      {
        a("loginInfo is null", paramCallback);
        return;
      }
      a(paramIQQLiveSDK, paramCallback);
      return;
    }
    QLog.e("QQLiveAnchor_Login", 1, "doLogin, something is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperLogin
 * JD-Core Version:    0.7.0.1
 */