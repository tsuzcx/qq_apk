package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import mqq.app.AppRuntime;

public class DownloaderFactoryProxy
  extends AbsManagerProxy<DownloaderFactory>
{
  public static final String ACTION_DOWNLOADERFACTORY_DOWNLOADER = "common_downloader_start_download";
  public static final String DOWNLOAD_FILE_THUMB = "download_file_thumb";
  public static final String DOWNLOAD_TYPE = "download_Type";
  public static final String DOWNLOAD_URL = "download_url";
  public static final String TAG = "DownloaderFactoryProxy";
  
  public DownloaderFactoryProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.DOWNLOADER_FACTORY);
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("common_downloader_start_download".equals(paramString)) {
      return onStartDownload((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onStartDownload(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface = (DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    paramInt = paramBundle.getInt("download_Type");
    paramString = paramBundle.getString("download_url");
    paramBundle = paramBundle.getString("download_file_thumb");
    paramQQAppInterface.a(paramInt).a(new DownloadTask(paramString, new File(paramBundle)), null, null);
    return EIPCResult.createSuccessResult(null);
  }
  
  public void startDownload(int paramInt, String paramString1, String paramString2)
  {
    if (this.manager != null) {
      ((DownloaderFactory)this.manager).a(paramInt).a(new DownloadTask(paramString1, new File(paramString2)), null, null);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("download_Type", paramInt);
      localBundle.putString("download_url", paramString1);
      localBundle.putString("download_file_thumb", paramString2);
      paramString1 = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "common_downloader_start_download", localBundle);
      if ((paramString1 == null) || (!paramString1.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DownloaderFactoryProxy", 4, "startDownload suc.");
    return;
    QLog.e("DownloaderFactoryProxy", 4, "startDownload fail.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.DownloaderFactoryProxy
 * JD-Core Version:    0.7.0.1
 */