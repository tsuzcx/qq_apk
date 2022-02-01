package com.tencent.qqmini.sdk.server;

import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;

class MiniAppCmdServlet$2
  implements DownloaderProxy.DownloadListener
{
  MiniAppCmdServlet$2(MiniAppCmdServlet paramMiniAppCmdServlet, MiniCmdCallback paramMiniCmdCallback) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.e("MiniAppCmdServlet", "download v8rt failed: " + paramString);
    if (this.val$callback != null) {}
    try
    {
      this.val$callback.onCmdResult(false, null);
      return;
    }
    catch (Exception paramString)
    {
      QMLog.e("MiniAppCmdServlet", "download v8rt failed,callback.onCmdResult exception ", paramString);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    QMLog.i("MiniAppCmdServlet", "download v8rt succeed progress: " + paramFloat + " totalBytesWritten:" + paramLong1 + "  totalBytesExpectedToWrite:" + paramLong2);
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    QMLog.e("MiniAppCmdServlet", "download v8rt succeed: " + paramString + " result:" + paramDownloadResult);
    if (this.val$callback != null) {}
    try
    {
      this.val$callback.onCmdResult(true, null);
      return;
    }
    catch (Exception paramString)
    {
      QMLog.e("MiniAppCmdServlet", "download v8rt failed,callback.onCmdResult exception ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.MiniAppCmdServlet.2
 * JD-Core Version:    0.7.0.1
 */