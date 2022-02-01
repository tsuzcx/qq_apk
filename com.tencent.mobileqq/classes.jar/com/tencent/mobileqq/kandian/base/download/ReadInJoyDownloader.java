package com.tencent.mobileqq.kandian.base.download;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDownloader;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import mqq.os.MqqHandler;

public class ReadInJoyDownloader
  implements IReadInJoyDownloader
{
  private static final String CLIENT_KEY = "ReadInJoyDownloader";
  private static final int SDK_INITIALIZATION_DELAY_MS = 15000;
  private static final String TAG = "ReadInJoyDownloader";
  private static volatile ReadInJoyDownloader sInstance;
  private TMAssistantDownloadClient downloadSDKClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  private final DownloadListenerDelegate listenerDelegate = new DownloadListenerDelegate();
  
  private ReadInJoyDownloader()
  {
    this.downloadSDKClient.registerDownloadTaskListener(this.listenerDelegate);
  }
  
  public static ReadInJoyDownloader getInstance()
  {
    if (sInstance != null) {
      return sInstance;
    }
    try
    {
      if (sInstance == null) {
        sInstance = new ReadInJoyDownloader();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void startDownload(ReadInJoyDownloader.WrappedDownloadInfo paramWrappedDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, paramWrappedDownloadInfo), 15000L);
  }
  
  public void addDownloadListener(DownloadListener paramDownloadListener)
  {
    this.listenerDelegate.a(paramDownloadListener);
  }
  
  public void pauseDownload(String paramString)
  {
    TMAssistantDownloadClient localTMAssistantDownloadClient = this.downloadSDKClient;
    if (localTMAssistantDownloadClient != null) {
      localTMAssistantDownloadClient.pauseDownloadTask(paramString);
    }
  }
  
  public void removeDownloadListener(DownloadListener paramDownloadListener)
  {
    this.listenerDelegate.b(paramDownloadListener);
  }
  
  public void startDownload(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    DownloadDBHelper.a().a(paramDownloadInfo);
    startDownload(new ReadInJoyDownloader.WrappedDownloadInfo(paramDownloadInfo, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.download.ReadInJoyDownloader
 * JD-Core Version:    0.7.0.1
 */