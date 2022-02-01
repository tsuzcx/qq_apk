package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;

class SPlayerPreDownloaderImpl$2
  implements Runnable
{
  SPlayerPreDownloaderImpl$2(SPlayerPreDownloaderImpl paramSPlayerPreDownloaderImpl, int paramInt) {}
  
  public void run()
  {
    String str = SPlayerPreDownloaderImpl.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopAllPreDownload(), stop taskIdForTPProxy=");
    localStringBuilder.append(this.val$taskIdForTPProxy);
    LogUtil.d(str, localStringBuilder.toString());
    SPlayerPreDownloaderImpl.access$000(this.this$0).stopPreload(this.val$taskIdForTPProxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.2
 * JD-Core Version:    0.7.0.1
 */