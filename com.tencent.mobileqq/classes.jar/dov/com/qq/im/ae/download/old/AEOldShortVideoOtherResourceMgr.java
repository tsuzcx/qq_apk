package dov.com.qq.im.ae.download.old;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class AEOldShortVideoOtherResourceMgr
{
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("other_res_short_video_mgr_sp", 4).getString("other_res_sv_md5_version_soname_key", "other_res000_0");
    boolean bool = AEOldPendantVersionManager.a(str, 1);
    VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "other_res000_0";
  }
  
  static boolean a()
  {
    return true;
  }
  
  static boolean a(AppInterface paramAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    return false;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    paramQQAppInterface = b();
    paramQQAppInterface = paramQQAppInterface + paramString1 + File.separator;
    File localFile = new File(paramQQAppInterface);
    if (localFile.exists()) {
      if ((a().equals(paramString1)) && (AEOldPendantVersionManager.a(paramQQAppInterface, "other_res_config_file"))) {
        VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:[checkUnzipFileListSizeIsOK]success=true", null);
      }
    }
    for (;;)
    {
      return false;
      FileUtils.a(paramQQAppInterface);
      VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:[deleteDirectory|already exists]unzipPath=" + paramQQAppInterface, null);
      boolean bool = localFile.mkdirs();
      VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:[exists]mkOK=" + bool, null);
      try
      {
        FileUtils.a(paramString2, paramQQAppInterface, false);
        bool = AEOldPendantVersionManager.a(paramQQAppInterface, "other_res_config_file");
        VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK success=" + bool, null);
        if (bool)
        {
          bool = a(paramString1);
          VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK saveOK=" + bool, null);
          if (bool) {
            continue;
          }
          bool = a(paramString1);
          VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two]saveOK=" + bool, null);
          return false;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return true;
      }
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("other_res_short_video_mgr_sp", 4).edit();
    localEditor.putString("other_res_sv_md5_version_soname_key", paramString);
    return localEditor.commit();
  }
  
  public static String b()
  {
    String str = PtvFilterSoLoad.b();
    return str + "other_res_cache" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoOtherResourceMgr
 * JD-Core Version:    0.7.0.1
 */