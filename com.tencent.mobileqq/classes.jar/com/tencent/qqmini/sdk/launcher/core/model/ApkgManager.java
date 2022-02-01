package com.tencent.qqmini.sdk.launcher.core.model;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;

public class ApkgManager
{
  private static final String TAG = "ApkgManager";
  private static volatile ApkgManager sInstance;
  
  public static String getApkgFolderPath(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return "";
    }
    if (paramMiniAppInfo.verType == 3) {
      return getPkgRoot(paramMiniAppInfo) + MD5Utils.toMD5(paramMiniAppInfo.appId) + "_" + paramMiniAppInfo.versionId;
    }
    return getPkgRoot(paramMiniAppInfo) + paramMiniAppInfo.appId + "_debug";
  }
  
  public static ApkgManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new ApkgManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static String getPkgRoot(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      return ApkgManager.RootPath.access$000();
    }
    if (paramMiniAppInfo.launchParam.isFlutterMode) {
      return ApkgManager.RootPath.access$100();
    }
    return ApkgManager.RootPath.access$200();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.ApkgManager
 * JD-Core Version:    0.7.0.1
 */