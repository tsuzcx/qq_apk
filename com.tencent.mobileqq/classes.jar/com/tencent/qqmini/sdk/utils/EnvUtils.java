package com.tencent.qqmini.sdk.utils;

import bgrb;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class EnvUtils
{
  public static boolean isPkgDownloaded(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return false;
    }
    return bgrb.a(paramMiniAppInfo);
  }
  
  public static boolean isX5Enabled(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.EnvUtils
 * JD-Core Version:    0.7.0.1
 */