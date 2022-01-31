package com.tencent.mobileqq.shortvideo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.TrackerSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class ShortVideoTrackingResourceMgr
{
  private static String a = "Xiaomi;Redmi 4X;23|LGE;Nexus 5X;27|HUAWEI;CAM-UL00;23";
  
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    if (paramSVConfigItem.versionCode >= 1) {}
    for (int i = 0;; i = -4)
    {
      VideoEnvironment.a("ShortVideoTrackingResourceMgr", "[checkResourceLowLimitVersion]limitVer=1 downVer=" + paramSVConfigItem.versionCode + " errCode=" + i, null);
      return i;
    }
  }
  
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("tracking_short_video_mgr_sp", 4).getString("tracking_sv_md5_version_soname_key", "Tracking000_0");
    boolean bool = PendantVersionManager.a(str, 1);
    VideoEnvironment.a("ShortVideoTrackingResourceMgr", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "Tracking000_0";
  }
  
  public static boolean a()
  {
    return TrackerSoLoader.a();
  }
  
  public static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    return PtvFilterSoLoad.g();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    label349:
    for (;;)
    {
      try
      {
        paramQQAppInterface = b();
        paramQQAppInterface = paramQQAppInterface + paramString1 + File.separator;
        File localFile = new File(paramQQAppInterface);
        if (localFile.exists())
        {
          if ((a().equals(paramString1)) && (PendantVersionManager.b(paramQQAppInterface, "tracking_config_file")))
          {
            VideoEnvironment.a("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:[checkUnzipFileListSizeIsOK]success=true", null);
            return bool1;
          }
          FileUtils.a(paramQQAppInterface);
          VideoEnvironment.a("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:[deleteDirectory|already exists]unzipPath=" + paramQQAppInterface, null);
        }
        bool1 = localFile.mkdirs();
        VideoEnvironment.a("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:[exists]mkOK=" + bool1, null);
        try
        {
          FileUtils.a(paramString2, paramQQAppInterface, false);
          boolean bool3 = PendantVersionManager.b(paramQQAppInterface, "tracking_config_file");
          VideoEnvironment.a("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK success=" + bool3, null);
          bool1 = bool2;
          if (bool3)
          {
            bool1 = a(paramString1);
            VideoEnvironment.a("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK saveOK=" + bool1, null);
            if (bool1) {
              break label349;
            }
            bool1 = a(paramString1);
            VideoEnvironment.a("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK[two]saveOK=" + bool1, null);
            if (bool1) {
              break label349;
            }
            VideoEnvironment.a("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
            bool1 = a("Tracking000_0");
            VideoEnvironment.a("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + bool1 + ",signature=" + paramString1, null);
            bool1 = bool2;
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          bool1 = bool2;
          continue;
        }
        bool1 = false;
      }
      finally {}
    }
  }
  
  private static boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("tracking_short_video_mgr_sp", 4).edit();
    localEditor.putString("tracking_sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.a("ShortVideoTrackingResourceMgr", "storeNewPendantUnzipPath commitValue=" + bool + ",pathName=" + paramString, null);
    return bool;
  }
  
  public static String b()
  {
    String str = PtvFilterSoLoad.a(VideoEnvironment.a());
    return str + "tracking_res_cache" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoTrackingResourceMgr
 * JD-Core Version:    0.7.0.1
 */