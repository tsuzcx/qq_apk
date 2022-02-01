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
  public static final int AUDIT = 2;
  public static final int AUDIT_PASS = 6;
  public static final int AUDIT_REJECT = 7;
  public static final String BASE_LIB_PATH_DIR;
  public static final String CONFIG_DEFAULT_BASE_LIB_VERSION = "1.22.0.00008";
  public static final int DELETED = 5;
  public static final int DEVELOP = 0;
  public static final int DO_USE_SDK = 1;
  public static final String ENG_LOG_TAG = "[MiniEng]";
  public static final int EXPERIENCE = 1;
  public static final int GRAY_RELEASE = 8;
  public static final String KEY_BASELIB_LOCAL_URL = "downloadUrl";
  public static final String KEY_BASELIB_LOCAL_VERSION = "version";
  public static final String KEY_USE_SDK = "usersdk";
  public static final String LIB_V8RT = "libtv8rt.so";
  public static final int MESSENGER_CMD_NOTIFY_PERIODIC_CACHE_UPDATE = 1002;
  public static final int MESSENGER_CMD_NOTIFY_SHARE_RESULT = 1001;
  public static final String NOTIFY_EVENT_ONPAUSE = "onPause";
  public static final String NOTIFY_EVENT_ONRESUME = "onResume";
  public static final int NOT_USE_SDK = 0;
  public static final int OFFLINE = 9;
  public static final int ONLINE = 3;
  public static final String PATH_WXAPKG_ROOT;
  public static final int PREVIEW = 4;
  public static final String SDK_CONF = "sdk_conf";
  public static final int START_MODE_APPID = 1;
  public static final int START_MODE_LINK = 2;
  public static final int START_MODE_NORMAL = 0;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppLoaderFactory.g().getContext().getFilesDir().getPath());
    localStringBuilder.append("/mini/");
    PATH_WXAPKG_ROOT = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PATH_WXAPKG_ROOT);
    localStringBuilder.append("baseLib");
    BASE_LIB_PATH_DIR = localStringBuilder.toString();
  }
  
  public static String getAppBaseLibDir(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {}
    try
    {
      localObject = MD5Utils.toMD5(paramString1);
      paramString1 = (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label27:
      label35:
      break label27;
    }
    try
    {
      paramString1 = MD5Utils.encodeHexStr(paramString1);
    }
    catch (Throwable paramString1)
    {
      break label35;
    }
    paramString1 = "";
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BASE_LIB_PATH_DIR);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
    return null;
  }
  
  public static String getMiniAppV8rtPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApkgManager.RootPath.getRoot());
    localStringBuilder.append("/miniapptv8rt/");
    localStringBuilder.append("libtv8rt.so");
    return localStringBuilder.toString();
  }
  
  public static String getQQAppBaseLibDir(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {}
    try
    {
      localObject = MD5Utils.toMD5(paramString1);
      paramString1 = (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label27:
      label35:
      break label27;
    }
    try
    {
      paramString1 = MD5Utils.encodeHexStr(paramString1);
    }
    catch (Throwable paramString1)
    {
      break label35;
    }
    paramString1 = "";
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BASE_LIB_PATH_DIR);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniSDKConst
 * JD-Core Version:    0.7.0.1
 */