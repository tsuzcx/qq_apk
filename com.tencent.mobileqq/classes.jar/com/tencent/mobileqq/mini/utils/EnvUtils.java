package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class EnvUtils
{
  public static boolean isPkgDownloaded(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {
      return false;
    }
    return ApkgManager.pkgExists(paramMiniAppConfig.config);
  }
  
  public static boolean isX5Enabled(MiniAppInfo paramMiniAppInfo)
  {
    return paramMiniAppInfo != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.EnvUtils
 * JD-Core Version:    0.7.0.1
 */