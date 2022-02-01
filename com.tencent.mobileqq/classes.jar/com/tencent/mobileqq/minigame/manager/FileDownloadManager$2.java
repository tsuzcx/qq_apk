package com.tencent.mobileqq.minigame.manager;

import android.os.SystemClock;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.MiniDownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import java.util.List;
import java.util.Map;

final class FileDownloadManager$2
  implements Downloader.MiniDownloadListener
{
  private long beginEnqueue = SystemClock.uptimeMillis();
  Map<String, List<String>> headers;
  
  FileDownloadManager$2(DownloaderProxy.DownloadListener paramDownloadListener, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onDownloadFailed(-5, "abort");
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onDownloadFailed(paramDownloadResult.getStatus().httpStatus, paramDownloadResult.getStatus().getErrorMessage());
    }
  }
  
  public void onDownloadHeadersReceived(String paramString, int paramInt, Map<String, List<String>> paramMap)
  {
    this.headers = paramMap;
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onDownloadHeadersReceived(paramInt, paramMap);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onDownloadProgress(paramFloat, ((float)paramLong * paramFloat), paramLong);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onDownloadSucceed(paramDownloadResult.getStatus().httpStatus, this.val$filePath, FileDownloadManager.access$100(paramDownloadResult, this.headers));
    }
    paramString = new StringBuilder();
    paramString.append("downloadWithDownloader [timecost=");
    paramString.append(SystemClock.uptimeMillis() - this.beginEnqueue);
    paramString.append("][receiveData=");
    paramString.append(paramDownloadResult.getReport().t_recvdata);
    paramString.append("][connect=");
    paramString.append(paramDownloadResult.getReport().t_conn);
    paramString.append("][duration=");
    paramString.append(paramDownloadResult.getProcess().duration);
    paramString.append("][totalDuration=");
    paramString.append(paramDownloadResult.getProcess().totalDuration);
    paramString.append("][wait=");
    paramString.append(paramDownloadResult.getReport().t_wait);
    paramString.append("][url=");
    paramString.append(this.val$url);
    paramString.append("]");
    QLog.e("FileDownloadManager", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */