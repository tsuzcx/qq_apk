package com.tencent.mobileqq.qqlive.biz.sdk;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig.Builder;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class QQLiveSDKHelper
{
  public static IQQLiveSDK a(AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    paramAppRuntime = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    QQLiveSDKConfig localQQLiveSDKConfig = QQLiveSDKConfig.createBuilder().build();
    if (!paramAppRuntime.isInited()) {
      paramAppRuntime.init(localAppRuntime, localQQLiveSDKConfig);
    }
    return paramAppRuntime;
  }
  
  public static void a(IQQLiveSDK paramIQQLiveSDK, IQQLiveLoginCallback paramIQQLiveLoginCallback)
  {
    if (paramIQQLiveSDK == null) {
      return;
    }
    IQQLiveModuleLogin localIQQLiveModuleLogin = paramIQQLiveSDK.getLoginModule();
    if (localIQQLiveModuleLogin == null) {
      return;
    }
    AppRuntime localAppRuntime = paramIQQLiveSDK.getAppRuntime();
    if (localAppRuntime == null) {
      return;
    }
    if (!localIQQLiveModuleLogin.isLogined())
    {
      paramIQQLiveSDK = new LoginRequest();
      paramIQQLiveSDK.uin = localAppRuntime.getCurrentUin();
      paramIQQLiveSDK.qqA2 = ((TicketManager)localAppRuntime.getManager(2)).getA2(paramIQQLiveSDK.uin);
      localIQQLiveModuleLogin.login(paramIQQLiveSDK, new QQLiveSDKHelper.1(paramIQQLiveLoginCallback));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("QQLiveSDKHelper", 1, "already logined");
      if (paramIQQLiveSDK.getLoginModule().getLoginInfo() != null)
      {
        paramIQQLiveLoginCallback = new StringBuilder();
        paramIQQLiveLoginCallback.append("uid ");
        paramIQQLiveLoginCallback.append(paramIQQLiveSDK.getLoginModule().getLoginInfo().uid);
        QLog.d("QQLiveSDKHelper", 2, paramIQQLiveLoginCallback.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.biz.sdk.QQLiveSDKHelper
 * JD-Core Version:    0.7.0.1
 */