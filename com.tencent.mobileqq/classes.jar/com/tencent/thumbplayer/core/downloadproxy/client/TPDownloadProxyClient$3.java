package com.tencent.thumbplayer.core.downloadproxy.client;

import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;

class TPDownloadProxyClient$3
  extends ITPPreLoadListenerAidl.Stub
{
  TPDownloadProxyClient$3(TPDownloadProxyClient paramTPDownloadProxyClient, ITPPreLoadListener paramITPPreLoadListener) {}
  
  public void onPcdnDownloadFailed(String paramString)
  {
    this.val$itpPreLoadListener.onPcdnDownloadFailed(paramString);
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    this.val$itpPreLoadListener.onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
  }
  
  public void onPrepareError(int paramInt1, int paramInt2, String paramString)
  {
    this.val$itpPreLoadListener.onPrepareError(paramInt1, paramInt2, paramString);
  }
  
  public void onPrepareOK()
  {
    this.val$itpPreLoadListener.onPrepareOK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient.3
 * JD-Core Version:    0.7.0.1
 */