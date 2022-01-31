package com.tencent.thumbplayer.core.downloadproxy.service;

import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;

class TPDownloadProxyService$DownloadProxy$3
  implements ITPPreLoadListener
{
  TPDownloadProxyService$DownloadProxy$3(TPDownloadProxyService.DownloadProxy paramDownloadProxy, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl) {}
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    try
    {
      if (this.val$preloadListener != null) {
        this.val$preloadListener.onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareDownloadProgressUpdate failed, error:" + localThrowable.toString());
    }
  }
  
  public void onPrepareError()
  {
    try
    {
      if (this.val$preloadListener != null) {
        this.val$preloadListener.onPrepareError();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareError failed, error:" + localThrowable.toString());
    }
  }
  
  public void onPrepareOK()
  {
    try
    {
      if (this.val$preloadListener != null) {
        this.val$preloadListener.onPrepareOK();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareOK failed, error:" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.3
 * JD-Core Version:    0.7.0.1
 */