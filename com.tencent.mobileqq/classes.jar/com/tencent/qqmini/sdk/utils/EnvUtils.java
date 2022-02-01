package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;

public class EnvUtils
{
  public static boolean isPkgDownloaded(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return false;
    }
    return ApkgManager.pkgExists(paramMiniAppInfo);
  }
  
  public static boolean isX5Enabled(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.EnvUtils
 * JD-Core Version:    0.7.0.1
 */