package com.tencent.thumbplayer.core.downloadproxy.service;

import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;

class TPDownloadProxyService$DownloadProxy$3
  implements ITPPreLoadListener
{
  TPDownloadProxyService$DownloadProxy$3(TPDownloadProxyService.DownloadProxy paramDownloadProxy, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl) {}
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      if (this.val$preloadListener != null)
      {
        this.val$preloadListener.onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrepareDownloadProgressUpdate failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void onPrepareError(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      if (this.val$preloadListener != null)
      {
        this.val$preloadListener.onPrepareError(paramInt1, paramInt2, paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrepareError failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void onPrepareOK()
  {
    try
    {
      if (this.val$preloadListener != null)
      {
        this.val$preloadListener.onPrepareOK();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrepareOK failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.3
 * JD-Core Version:    0.7.0.1
 */