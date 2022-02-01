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
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;

public class AEOldShortVideoPortraitResourceManager
{
  private static String a = "Xiaomi;Redmi 4X;23|LGE;Nexus 5X;27|HUAWEI;CAM-UL00;23|Meizu;M2 E;23|vivo;vivo X9s Plus L;25";
  
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("portrait_short_video_mgr_sp", 4).getString("portrait_sv_md5_version_soname_key", "Portrait000_0");
    boolean bool = ((IAEOldResPendentVersion)QRoute.api(IAEOldResPendentVersion.class)).checkSignatureVersionIsOK(str, 9);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurrentPendantUnzipPath success=");
    localStringBuilder.append(bool);
    localStringBuilder.append(",md5Version=");
    localStringBuilder.append(str);
    VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", localStringBuilder.toString(), null);
    if (bool) {
      return str;
    }
    return "Portrait000_0";
  }
  
  public static void a() {}
  
  static boolean a()
  {
    return FeatureManager.Features.LIGHT_SDK.isFunctionReady();
  }
  
  static boolean a(AppInterface paramAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    return PtvFilterSoLoad.e();
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    try
    {
      paramQQAppInterface = b();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(File.separator);
      paramQQAppInterface = ((StringBuilder)localObject).toString();
      localObject = new File(paramQQAppInterface);
      boolean bool1 = ((File)localObject).exists();
      boolean bool2 = false;
      if (bool1)
      {
        if ((a().equals(paramString1)) && (((IAEOldResPendentVersion)QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(paramQQAppInterface, "portrait_config_file")))
        {
          VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:[checkUnzipFileListSizeIsOK]success=true", null);
          return false;
        }
        FileUtils.deleteDirectory(paramQQAppInterface);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uncompressPortraitZip:[deleteDirectory|already exists]unzipPath=");
        localStringBuilder.append(paramQQAppInterface);
        VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", localStringBuilder.toString(), null);
      }
      bool1 = ((File)localObject).mkdirs();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uncompressPortraitZip:[exists]mkOK=");
      ((StringBuilder)localObject).append(bool1);
      VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", ((StringBuilder)localObject).toString(), null);
      boolean bool3 = true;
      try
      {
        FileUtils.uncompressZip(paramString2, paramQQAppInterface, false);
        boolean bool4 = ((IAEOldResPendentVersion)QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(paramQQAppInterface, "portrait_config_file");
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("uncompressPortraitZip:checkUnzipFileListSizeIsOK success=");
        paramQQAppInterface.append(bool4);
        VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", paramQQAppInterface.toString(), null);
        bool1 = bool3;
        if (bool4)
        {
          bool4 = a(paramString1);
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("uncompressPortraitZip:checkUnzipFileListSizeIsOK saveOK=");
          paramQQAppInterface.append(bool4);
          VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", paramQQAppInterface.toString(), null);
          bool1 = bool2;
          if (!bool4)
          {
            bool4 = a(paramString1);
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("uncompressPortraitZip:checkUnzipFileListSizeIsOK[two]saveOK=");
            paramQQAppInterface.append(bool4);
            VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", paramQQAppInterface.toString(), null);
            bool1 = bool2;
            if (!bool4)
            {
              VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
              bool1 = a("Portrait000_0");
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("uncompressPortraitZip:checkUnzipFileListSizeIsOK clearMemoryOK=");
              paramQQAppInterface.append(bool1);
              paramQQAppInterface.append(",signature=");
              paramQQAppInterface.append(paramString1);
              VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", paramQQAppInterface.toString(), null);
              bool1 = true;
            }
          }
          a();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        bool1 = bool3;
      }
      return bool1;
    }
    finally {}
  }
  
  private static boolean a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("portrait_short_video_mgr_sp", 4).edit();
    ((SharedPreferences.Editor)localObject).putString("portrait_sv_md5_version_soname_key", paramString);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("storeNewPendantUnzipPath commitValue=");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(",pathName=");
    ((StringBuilder)localObject).append(paramString);
    VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", ((StringBuilder)localObject).toString(), null);
    return bool;
  }
  
  public static String b()
  {
    String str = ((IAEOldPath)QRoute.api(IAEOldPath.class)).getPendantBasePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("portrait_res_cache");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoPortraitResourceManager
 * JD-Core Version:    0.7.0.1
 */