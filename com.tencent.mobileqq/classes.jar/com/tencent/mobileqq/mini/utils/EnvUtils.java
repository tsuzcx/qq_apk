package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;

public class EnvUtils
{
  public static boolean isPkgDownloaded(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {
      return false;
    }
    if (paramMiniAppConfig.isEngineTypeMiniGame()) {
      return GpkgManager.pkgExists(paramMiniAppConfig.config);
    }
    return ApkgManager.pkgExists(paramMiniAppConfig.config);
  }
  
  public static boolean isX5Enabled(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return false;
      paramMiniAppInfo = AppBrandRuntimeContainer.g().getAppBrandRunTime(paramMiniAppInfo);
    } while ((paramMiniAppInfo == null) || (!(paramMiniAppInfo.serviceRuntime instanceof ServiceWebview)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.EnvUtils
 * JD-Core Version:    0.7.0.1
 */