import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class nvq
  implements nvn
{
  private static HashMap<String, nvl> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new nvr(this);
  public TMAssistantDownloadClient a;
  
  public int a(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload");
    try
    {
      paramContext = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (paramContext == null) {
        return 0;
      }
      int i = paramContext.mState;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, nuw paramnuw, Map<String, String> paramMap)
  {
    if (paramnuw == null) {
      return;
    }
    if (paramContext == null)
    {
      paramnuw.loaded(paramString1, 11);
      return;
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      paramnuw.loaded(paramString1, 12);
      return;
    }
    if (AppNetConnInfo.getRecentNetworkInfo() == null)
    {
      paramnuw.loaded(paramString1, 10);
      return;
    }
    Object localObject = new File(paramString3.substring(0, paramString3.lastIndexOf("/")));
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      paramnuw.loaded(paramString1, 13);
      return;
    }
    localObject = Md5Utils.getMD5(paramString1);
    paramString2 = new nvl((String)localObject, paramString3, paramString2, paramnuw);
    jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKClient("OfflineDownload");
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    for (;;)
    {
      int i;
      try
      {
        i = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.startDownloadTask(paramString1, 0, "resource/tm.android.unknown", (String)localObject, paramMap);
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OfflineDownload", 2, "offline downloader start, url: " + paramString1);
          }
          try
          {
            paramString3 = new DownloadInfo();
            paramString3.d = paramString1;
            paramString3.l = paramString2.b;
            paramString3.e = paramString2.jdField_a_of_type_JavaLangString;
            bjjp.a(paramContext, paramString3);
            return;
          }
          catch (Throwable paramContext)
          {
            return;
          }
        }
        if (i != 4) {
          break label365;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + -1 + ", url: " + paramString1);
        }
        paramnuw.loaded(paramString1, 10);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "offline downloader start fail, file exists, url: " + paramString1);
      }
      a(this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient, paramString2, paramString1);
      continue;
      label365:
      if (QLog.isColorLevel()) {
        QLog.d("OfflineDownload", 2, "offline downloader start fail, result " + i + ", url: " + paramString1);
      }
      paramnuw.loaded(paramString1, 10);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, nuw paramnuw)
  {
    a(paramContext, paramString1, "0", paramString2, paramnuw, null);
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, nvl paramnvl, String paramString)
  {
    TMAssistantDownloadClient localTMAssistantDownloadClient = null;
    Object localObject = null;
    try
    {
      paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (paramTMAssistantDownloadClient == null) {}
      for (paramTMAssistantDownloadClient = localObject;; paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.mSavePath)
      {
        localTMAssistantDownloadClient = paramTMAssistantDownloadClient;
        if (!TextUtils.isEmpty(paramTMAssistantDownloadClient)) {
          break;
        }
        a(paramnvl.jdField_a_of_type_Nuw, paramString, paramnvl.c, 14, "get current download path fail after download");
        return;
      }
      paramTMAssistantDownloadClient = new File(localTMAssistantDownloadClient);
    }
    catch (Exception paramTMAssistantDownloadClient)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("OfflineDownload", 4, paramTMAssistantDownloadClient.toString());
      }
    }
    finally
    {
      if (TextUtils.isEmpty(null))
      {
        a(paramnvl.jdField_a_of_type_Nuw, paramString, paramnvl.c, 14, "get current download path fail after download");
        return;
      }
    }
    if (!paramTMAssistantDownloadClient.exists())
    {
      a(paramnvl.jdField_a_of_type_Nuw, paramString, paramnvl.c, 15, "cannot get current file after download");
      return;
    }
    if (!FileUtils.copyFile(localTMAssistantDownloadClient, paramnvl.b))
    {
      a(paramnvl.jdField_a_of_type_Nuw, paramString, paramnvl.c, 16, "rename file fail after download");
      paramTMAssistantDownloadClient.delete();
      return;
    }
    a(paramnvl.jdField_a_of_type_Nuw, paramString, paramnvl.c, 0, "offline zip download success");
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.pauseDownloadTask(paramString);
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public void a(nuw paramnuw, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, paramString3 + ", bid: " + paramString2 + ", errCode: " + paramInt);
    }
    if ((paramnuw != null) && (paramInt >= 0)) {
      paramnuw.loaded(paramString1, paramInt);
    }
    jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvq
 * JD-Core Version:    0.7.0.1
 */