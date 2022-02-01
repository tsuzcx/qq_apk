package dov.com.qq.im.ae.download.old;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aelight.camera.download.old.api.IAEOldPath;
import com.tencent.aelight.camera.download.old.api.IAEOldResPendentVersion;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AEOldShortVideoArtResourceMgr
{
  int a = -1;
  
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("QmcfConfig", 4).getString("art_res_old_sv_md5_version_soname_key", "artfilter000_0");
    boolean bool = ((IAEOldResPendentVersion)QRoute.api(IAEOldResPendentVersion.class)).checkSignatureVersionIsOK(str, 9);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurrentPendantUnzipPath success=");
    localStringBuilder.append(bool);
    localStringBuilder.append(",md5Version=");
    localStringBuilder.append(str);
    VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", localStringBuilder.toString(), null);
    if (bool) {
      return str;
    }
    return "artfilter000_0";
  }
  
  private static void a()
  {
    ThreadManager.post(new AEOldShortVideoArtResourceMgr.1(), 5, null, false);
  }
  
  static boolean a()
  {
    return PtvFilterSoLoad.d();
  }
  
  static boolean a(AppInterface paramAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    if (!PtvFilterSoLoad.c()) {
      return false;
    }
    int i = QmcfDevicesStrategy.a();
    QmcfManager.getInstance().setCurrFrameType(i);
    if (QLog.isColorLevel()) {
      QLog.d("AEOldShortVideoArtResourceMgr", 2, String.format("supportFrameType[%s]", new Object[] { Integer.valueOf(i) }));
    }
    if (i != -2)
    {
      if (i != 0)
      {
        if (i != 1) {
          return true;
        }
        paramSVConfigItem.armv7a_url = paramSVConfigItem.extend1;
        paramSVConfigItem.armv7a_md5 = paramSVConfigItem.extend2;
        return true;
      }
      QmcfManager.getInstance().setQmcfMobileNotSupport(QmcfDevicesStrategy.a);
    }
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
    boolean bool1 = ((File)localObject).exists();
    boolean bool2 = false;
    if (bool1)
    {
      if ((a().equals(paramString1)) && (((IAEOldResPendentVersion)QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(paramQQAppInterface, "artfilter_config_file")))
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:[checkConfigFileListIsOK]success=true", null);
        return false;
      }
      FileUtils.deleteDirectory(paramQQAppInterface);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uncompressPendantZip:[deleteDirectory|already exists]unzipPath=");
      localStringBuilder.append(paramQQAppInterface);
      VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", localStringBuilder.toString(), null);
    }
    bool1 = ((File)localObject).mkdirs();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uncompressPendantZip:[exists]mkOK=");
    ((StringBuilder)localObject).append(bool1);
    VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", ((StringBuilder)localObject).toString(), null);
    try
    {
      FileUtils.uncompressZip(paramString2, paramQQAppInterface, false);
      bool1 = ((IAEOldResPendentVersion)QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(paramQQAppInterface, "artfilter_config_file");
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("uncompressPendantZip:checkConfigFileListIsOK success=");
      paramQQAppInterface.append(bool1);
      VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", paramQQAppInterface.toString(), null);
      if (bool1)
      {
        boolean bool3 = a(paramString1);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("uncompressPendantZip:checkConfigFileListIsOK saveOK=");
        paramQQAppInterface.append(bool3);
        VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", paramQQAppInterface.toString(), null);
        bool1 = bool2;
        if (!bool3)
        {
          bool3 = a(paramString1);
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("uncompressPendantZip:checkConfigFileListIsOK[two]saveOK=");
          paramQQAppInterface.append(bool3);
          VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", paramQQAppInterface.toString(), null);
          bool1 = bool2;
          if (!bool3)
          {
            VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
            bool1 = a("artfilter000_0");
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("uncompressPendantZip:checkUnzipFileListSizeIsOK clearMemoryOK=");
            paramQQAppInterface.append(bool1);
            paramQQAppInterface.append(",signature=");
            paramQQAppInterface.append(paramString1);
            VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", paramQQAppInterface.toString(), null);
            bool1 = true;
          }
        }
        a();
        return bool1;
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
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("QmcfConfig", 4).edit();
    localEditor.putString("art_res_old_sv_md5_version_soname_key", paramString);
    return localEditor.commit();
  }
  
  public static String b()
  {
    String str = ((IAEOldPath)QRoute.api(IAEOldPath.class)).getPendantBasePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("art_res_cache");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoArtResourceMgr
 * JD-Core Version:    0.7.0.1
 */