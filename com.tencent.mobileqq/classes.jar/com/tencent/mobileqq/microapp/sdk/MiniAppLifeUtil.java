package com.tencent.mobileqq.microapp.sdk;

import Wallet.ApkgConfig;
import agwb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.ext.GameProxy;
import mqq.app.AppRuntime;

public class MiniAppLifeUtil
{
  public static final int ACTION_NOTIFY_ON_BACK = 0;
  public static final String TAG = "MiniAppLifeUtil";
  
  public static void notifyLifeAction(int paramInt, MiniAppConfig paramMiniAppConfig)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      if (!(localAppRuntime instanceof QQAppInterface)) {
        break label31;
      }
      if (paramInt == 0) {
        onBack((QQAppInterface)localAppRuntime, paramMiniAppConfig);
      }
    }
    return;
    label31:
    agwb.a(paramInt, paramMiniAppConfig);
  }
  
  private static void onBack(QQAppInterface paramQQAppInterface, MiniAppConfig paramMiniAppConfig)
  {
    if ((paramQQAppInterface == null) || (!MiniAppConfig.isValid(paramMiniAppConfig))) {}
    while (LaunchParam.isCollectionPage(paramMiniAppConfig.config.mini_appid)) {
      return;
    }
    GameProxy.handleMiniAppBack(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppLifeUtil
 * JD-Core Version:    0.7.0.1
 */