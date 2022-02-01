package cooperation.gmersdk_warper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TMG_Downloader
{
  private static TMG_Downloader jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader;
  TMG_DownloadInfo jdField_a_of_type_CooperationGmersdk_warperTMG_DownloadInfo;
  TMG_Downloader.DownloadContrl jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl = new TMG_Downloader.DownloadContrl();
  TMG_Downloader.TMG_Downloader_DownloadEvent jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent;
  
  static SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.gme_sdk", 4);
  }
  
  static TMG_Downloader a()
  {
    if (jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader == null) {
      jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader = new TMG_Downloader();
    }
    return jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader;
  }
  
  public static String a()
  {
    Object localObject1 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, "getFilesDir is null");
      }
      return "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getParent());
    ((StringBuilder)localObject2).append("/txlib/gme_sdk/");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    return localObject1;
  }
  
  public static String a(TMG_DownloadInfo paramTMG_DownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("gme_sdk_");
    localStringBuilder.append(paramTMG_DownloadInfo.a);
    localStringBuilder.append("_");
    localStringBuilder.append(paramTMG_DownloadInfo.b);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    ArrayList localArrayList = FileUtils.getChildFiles(a());
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ListSoDirs file i=");
        localStringBuilder.append(i);
        localStringBuilder.append(", name=");
        localStringBuilder.append((String)localArrayList.get(i));
        QLog.e("TMG_Downloader", 1, String.format(localStringBuilder.toString(), new Object[0]));
        i += 1;
      }
    }
  }
  
  static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putString("gme_sdk_download_md5", paramString);
    localEditor.commit();
  }
  
  static String b()
  {
    return a().getString("gme_sdk_download_md5", null);
  }
  
  public static boolean b(TMG_DownloadInfo paramTMG_DownloadInfo)
  {
    String str1 = paramTMG_DownloadInfo.b;
    paramTMG_DownloadInfo = a(paramTMG_DownloadInfo);
    String str2 = b();
    if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1)))
    {
      if (!FileUtils.fileExists(paramTMG_DownloadInfo))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TMG_Downloader", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramTMG_DownloadInfo }));
        }
        return false;
      }
      a();
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TMG_Downloader", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
    }
    return false;
  }
  
  boolean a(TMG_DownloadInfo paramTMG_DownloadInfo)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      if (((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.MGR_NET_ENGINE) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TMG_Downloader", 4, "innerDownload, getNetEngine 为空");
        }
        return false;
      }
    }
    else if (QLog.isDevelopLevel()) {
      QLog.d("TMG_Downloader", 4, "appRuntime 不是 QQAppInterface");
    }
    this.jdField_a_of_type_CooperationGmersdk_warperTMG_DownloadInfo = paramTMG_DownloadInfo;
    return this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.a(paramTMG_DownloadInfo, this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent);
  }
  
  boolean a(TMG_DownloadInfo paramTMG_DownloadInfo, TMG_Downloader.TMG_Downloader_DownloadEvent paramTMG_Downloader_DownloadEvent)
  {
    this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent = paramTMG_Downloader_DownloadEvent;
    return a(paramTMG_DownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.gmersdk_warper.TMG_Downloader
 * JD-Core Version:    0.7.0.1
 */