package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;

class TPPreloadProxyImpl$1
  implements ITPPreLoadListener
{
  TPPreloadProxyImpl$1(TPPreloadProxyImpl paramTPPreloadProxyImpl, ITPPreloadProxy.IPreloadListener paramIPreloadListener) {}
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPreloadProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */