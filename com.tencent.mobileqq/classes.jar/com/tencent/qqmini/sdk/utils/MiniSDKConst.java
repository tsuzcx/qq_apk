package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import bgpx;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;

public class MiniSDKConst
{
  public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/";
  public static final int AUDIO_ROUTE_EARPIECE = 0;
  public static final int AUDIO_ROUTE_SPEAKER = 1;
  public static final int Audit = 2;
  public static final int AuditPass = 6;
  public static final int AuditReject = 7;
  public static final String CONFIG_DEFAULT_BASE_LIB_VERSION = "1.14.0.00225";
  public static final int Deleted = 5;
  public static final int Develop = 0;
  public static final String ENG_LOG_TAG = "[MiniEng]";
  public static final int Experience = 1;
  public static final String GPKG_LOG_TAG = "[Gpkg]";
  public static final int GrayRelease = 8;
  public static final String INNER_JSSDK_ASSETS_PATH = "mini";
  public static final String KEY_BASELIB_LOCAL_URL = "downloadUrl";
  public static final String KEY_BASELIB_LOCAL_VERSION = "version";
  public static final String KEY_BASELIB_MIN_UPDATE_TIME = "baselib_min_update_time";
  public static final String MINI_FILE_LOG_PATH = "/Tencent/mini/files/";
  public static final String MINI_SDK_VERSION = "1.3.1";
  public static final String MINI_TAG = "[mini] ";
  public static final int MULTI_ENTER_ROOM_RESULT_DEVICE_TAKE_UP = -2;
  public static final int MULTI_ENTER_ROOM_RESULT_DUPLICATE_CALL = -3;
  public static final int MULTI_ENTER_ROOM_RESULT_FAIL = -1;
  public static final int MULTI_ENTER_ROOM_RESULT_SUCCESS = 0;
  public static final int MULTI_ERROR_ENTER_ROOM_FAIL = 2;
  public static final int MULTI_ERROR_ENTER_ROOM_TIMEOUT = 1;
  public static final int MULTI_ERROR_INTERRUPT_BY_THIRD_CALL = 4;
  public static final int MULTI_ERROR_NET_ERROR = 3;
  public static final String ON_APP_LOW_MEMORY = "onMemoryWarning";
  public static final int Offline = 9;
  public static final int Online = 3;
  public static final int Preview = 4;
  public static final int START_MODE_APPID = 1;
  public static final int START_MODE_LINK = 2;
  public static final int START_MODE_NORMAL = 0;
  public static final String STR_WXFILE = bgpx.a("qqminiapp", "MiniAppFileString", "wxfile://");
  public static final String TAG = "miniapp-start";
  public static final String TAG_CHROMIUM = "miniapp-chromium";
  public static final String TAG_JS = "miniapp-JS";
  public static final String TAG_PROCESSOR = "miniapp-process";
  public static final String URL_UPGRADE = "https://m.q.qq.com/upgrade/{appid}";
  private static String gMiniCacheFilePath = "";
  
  private static String getExternalPath()
  {
    Object localObject3 = null;
    try
    {
      Object localObject1 = AppLoaderFactory.g().getContext().getExternalCacheDir();
      if (localObject1 != null)
      {
        QMLog.e("MiniSDKConst", "getExternalPath : " + ((File)localObject1).getParent());
        localObject1 = ((File)localObject1).getParent();
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        for (;;)
        {
          localObject2 = null;
        }
        localObject2 = localObject3;
      } while (!"mounted".equals(Environment.getExternalStorageState()));
      Object localObject2 = Environment.getExternalStorageDirectory();
      if (localObject2 != null)
      {
        QMLog.e("MiniSDKConst", "getExternalPath1 : " + ((File)localObject2).getPath() + "/Android/data/com.tencent.mobileqq/");
        return ((File)localObject2).getPath() + "/Android/data/com.tencent.mobileqq/";
      }
      localObject2 = AppLoaderFactory.g().getContext().getFilesDir();
      if (localObject2 != null)
      {
        QMLog.e("MiniAppGlobal", "getExternalPath2 : " + ((File)localObject2).getParent());
        return ((File)localObject2).getParent();
      }
      QMLog.e("MiniAppGlobal", "getExternalPath3 : /data/data/com.tencent.mobileqq/");
    }
    return "/data/data/com.tencent.mobileqq/";
  }
  
  public static String getMiniCacheFilePath()
  {
    if (TextUtils.isEmpty(gMiniCacheFilePath)) {
      gMiniCacheFilePath = getExternalPath() + "/Tencent/mini/files/";
    }
    return gMiniCacheFilePath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniSDKConst
 * JD-Core Version:    0.7.0.1
 */