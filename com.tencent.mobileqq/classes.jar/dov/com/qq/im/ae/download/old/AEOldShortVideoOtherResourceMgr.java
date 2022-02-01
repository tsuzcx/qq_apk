package dov.com.qq.im.ae.download.old;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aelight.camera.download.old.api.IAEOldPath;
import com.tencent.aelight.camera.download.old.api.IAEOldResPendentVersion;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class AEOldShortVideoOtherResourceMgr
{
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("other_res_short_video_mgr_sp", 4).getString("other_res_sv_md5_version_soname_key", "other_res000_0");
    boolean bool = ((IAEOldResPendentVersion)QRoute.api(IAEOldResPendentVersion.class)).checkSignatureVersionIsOK(str, 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurrentPendantUnzipPath success=");
    localStringBuilder.append(bool);
    localStringBuilder.append(",md5Version=");
    localStringBuilder.append(str);
    VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", localStringBuilder.toString(), null);
    if (bool) {
      return str;
    }
    return "other_res000_0";
  }
  
  static boolean a(AppInterface paramAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    return false;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    paramQQAppInterface = b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramQQAppInterface);
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(File.separator);
    paramQQAppInterface = ((StringBuilder)localObject).toString();
    localObject = new File(paramQQAppInterface);
    if (((File)localObject).exists())
    {
      if ((a().equals(paramString1)) && (((IAEOldResPendentVersion)QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(paramQQAppInterface, "other_res_config_file")))
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:[checkUnzipFileListSizeIsOK]success=true", null);
        return false;
      }
      FileUtils.deleteDirectory(paramQQAppInterface);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uncompressPendantZip:[deleteDirectory|already exists]unzipPath=");
      localStringBuilder.append(paramQQAppInterface);
      VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", localStringBuilder.toString(), null);
    }
    boolean bool = ((File)localObject).mkdirs();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uncompressPendantZip:[exists]mkOK=");
    ((StringBuilder)localObject).append(bool);
    VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", ((StringBuilder)localObject).toString(), null);
    try
    {
      FileUtils.uncompressZip(paramString2, paramQQAppInterface, false);
      bool = ((IAEOldResPendentVersion)QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(paramQQAppInterface, "other_res_config_file");
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("uncompressPendantZip:checkUnzipFileListSizeIsOK success=");
      paramQQAppInterface.append(bool);
      VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", paramQQAppInterface.toString(), null);
      if (bool)
      {
        bool = a(paramString1);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("uncompressPendantZip:checkUnzipFileListSizeIsOK saveOK=");
        paramQQAppInterface.append(bool);
        VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", paramQQAppInterface.toString(), null);
        if (!bool)
        {
          bool = a(paramString1);
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("uncompressPendantZip:checkUnzipFileListSizeIsOK[two]saveOK=");
          paramQQAppInterface.append(bool);
          VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", paramQQAppInterface.toString(), null);
        }
        return false;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
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
    String str = ((IAEOldPath)QRoute.api(IAEOldPath.class)).getPendantBasePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("other_res_cache");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  static boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoOtherResourceMgr
 * JD-Core Version:    0.7.0.1
 */