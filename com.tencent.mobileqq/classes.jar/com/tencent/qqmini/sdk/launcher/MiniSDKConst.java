package com.tencent.qqmini.sdk.launcher;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgManager.RootPath;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import java.io.File;

@MiniKeep
public class MiniSDKConst
{
  public static final String ACTION_PRELAUNCH_APP = "mini_prelaunch_app";
  public static final String ACTION_PRELOAD_APP = "mini_preload_app";
  public static final String ACTION_PRELOAD_GAME = "mini_preload_game";
  public static final int Audit = 2;
  public static final int AuditPass = 6;
  public static final int AuditReject = 7;
  public static final String BASE_LIB_PATH_DIR = PATH_WXAPKG_ROOT + ".baseLib";
  public static final String CONFIG_DEFAULT_BASE_LIB_VERSION = "1.19.0.00043";
  public static final int DO_USE_SDK = 1;
  public static final int Deleted = 5;
  public static final int Develop = 0;
  public static final String ENG_LOG_TAG = "[MiniEng]";
  public static final int Experience = 1;
  public static final int GrayRelease = 8;
  public static final String KEY_BASELIB_LOCAL_URL = "downloadUrl";
  public static final String KEY_BASELIB_LOCAL_VERSION = "version";
  public static final String KEY_USE_SDK = "usersdk";
  public static final String LIB_V8RT = "libtv8rt.so";
  public static final int MESSENGER_CMD_NOTIFY_PERIODIC_CACHE_UPDATE = 1002;
  public static final int MESSENGER_CMD_NOTIFY_SHARE_RESULT = 1001;
  public static final String NOTIFY_EVENT_ONPAUSE = "onPause";
  public static final String NOTIFY_EVENT_ONRESUME = "onResume";
  public static final int NOT_USE_SDK = 0;
  public static final int Offline = 9;
  public static final int Online = 3;
  public static final String PATH_WXAPKG_ROOT = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/";
  public static final int Preview = 4;
  public static final String SDK_CONF = "sdk_conf";
  public static final int START_MODE_APPID = 1;
  public static final int START_MODE_LINK = 2;
  public static final int START_MODE_NORMAL = 0;
  
  public static String getAppBaseLibDir(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    try
    {
      String str = MD5Utils.toMD5(paramString1);
      paramString1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          paramString1 = MD5Utils.encodeHexStr(paramString1);
        }
        catch (Throwable paramString1)
        {
          paramString1 = "";
        }
      }
    }
    return BASE_LIB_PATH_DIR + File.separator + paramString1 + "_" + paramString2 + File.separator;
  }
  
  public static String getMiniAppV8rtPath()
  {
    return ApkgManager.RootPath.getRoot() + "/miniapptv8rt/" + "libtv8rt.so";
  }
  
  public static String getQQAppBaseLibDir(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    try
    {
      String str = MD5Utils.toMD5(paramString1);
      paramString1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          paramString1 = MD5Utils.encodeHexStr(paramString1);
        }
        catch (Throwable paramString1)
        {
          paramString1 = "";
        }
      }
    }
    return BASE_LIB_PATH_DIR + File.separator + paramString1 + "_" + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniSDKConst
 * JD-Core Version:    0.7.0.1
 */