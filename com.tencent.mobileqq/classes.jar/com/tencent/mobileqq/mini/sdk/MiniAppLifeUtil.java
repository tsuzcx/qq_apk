package com.tencent.mobileqq.mini.sdk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.ext.GameProxy;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import mqq.app.AppRuntime;

public class MiniAppLifeUtil
{
  public static final int ACTION_NOTIFY_ON_BACK = 0;
  public static final String TAG = "MiniAppLifeUtil";
  
  public static void notifyLifeAction(int paramInt, MiniAppConfig paramMiniAppConfig)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (paramInt == 0)) {
      onBack((QQAppInterface)localAppRuntime, paramMiniAppConfig);
    }
  }
  
  private static void onBack(QQAppInterface paramQQAppInterface, MiniAppConfig paramMiniAppConfig)
  {
    if ((paramQQAppInterface == null) || (!MiniAppConfig.isValid(paramMiniAppConfig))) {}
    while (LaunchParam.isCollectionPage(paramMiniAppConfig.config.appId)) {
      return;
    }
    GameProxy.handleMiniAppBack(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLifeUtil
 * JD-Core Version:    0.7.0.1
 */