package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;

class TPPreloadProxyImpl$1
  implements ITPPreLoadListener
{
  TPPreloadProxyImpl$1(TPPreloadProxyImpl paramTPPreloadProxyImpl, ITPPreloadProxy.IPreloadListener paramIPreloadListener) {}
  
  public void onPcdnDownloadFailed(String paramString)
  {
    ITPPreloadProxy.IPreloadListener localIPreloadListener = this.val$listener;
    if (localIPreloadListener != null) {
      localIPreloadListener.onInfo(2101, 0L, 0L, paramString);
    }
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    ITPPreloadProxy.IPreloadListener localIPreloadListener = this.val$listener;
    if (localIPreloadListener != null) {
      localIPreloadListener.onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
    }
  }
  
  public void onPrepareError(int paramInt1, int paramInt2, String paramString)
  {
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onPrepareError();
    }
  }
  
  public void onPrepareOK()
  {
    ITPPreloadProxy.IPreloadListener localIPreloadListener = this.val$listener;
    if (localIPreloadListener != null) {
      localIPreloadListener.onPrepareSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPreloadProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */