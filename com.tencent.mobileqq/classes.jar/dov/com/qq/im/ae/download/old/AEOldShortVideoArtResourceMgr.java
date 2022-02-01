package dov.com.qq.im.ae.download.old;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
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
    boolean bool = AEOldPendantVersionManager.a(str, 9);
    VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
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
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      QmcfManager.getInstance().setQmcfMobileNotSupport(QmcfDevicesStrategy.a);
      return false;
      paramSVConfigItem.armv7a_url = paramSVConfigItem.extend1;
      paramSVConfigItem.armv7a_md5 = paramSVConfigItem.extend2;
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    paramQQAppInterface = b();
    paramQQAppInterface = paramQQAppInterface + paramString1 + File.separator;
    File localFile = new File(paramQQAppInterface);
    if (localFile.exists())
    {
      if ((a().equals(paramString1)) && (AEOldPendantVersionManager.a(paramQQAppInterface, "artfilter_config_file")))
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:[checkConfigFileListIsOK]success=true", null);
        return false;
      }
      FileUtils.a(paramQQAppInterface);
      VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:[deleteDirectory|already exists]unzipPath=" + paramQQAppInterface, null);
    }
    boolean bool1 = localFile.mkdirs();
    VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:[exists]mkOK=" + bool1, null);
    try
    {
      FileUtils.a(paramString2, paramQQAppInterface, false);
      bool1 = AEOldPendantVersionManager.a(paramQQAppInterface, "artfilter_config_file");
      VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK success=" + bool1, null);
      if (bool1)
      {
        boolean bool3 = a(paramString1);
        VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK saveOK=" + bool3, null);
        bool1 = bool2;
        if (!bool3)
        {
          bool3 = a(paramString1);
          VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK[two]saveOK=" + bool3, null);
          bool1 = bool2;
          if (!bool3)
          {
            VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
            bool1 = a("artfilter000_0");
            VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + bool1 + ",signature=" + paramString1, null);
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
      return true;
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
    String str = PtvFilterSoLoad.b();
    return str + "art_res_cache" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoArtResourceMgr
 * JD-Core Version:    0.7.0.1
 */