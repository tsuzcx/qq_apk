package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;

class SPlayerPreDownloaderImpl$2
  implements Runnable
{
  SPlayerPreDownloaderImpl$2(SPlayerPreDownloaderImpl paramSPlayerPreDownloaderImpl, int paramInt) {}
  
  public void run()
  {
    LogUtil.d(SPlayerPreDownloaderImpl.TAG, "stopAllPreDownload(), stop taskIdForTPProxy=" + this.val$taskIdForTPProxy);
    SPlayerPreDownloaderImpl.access$000(this.this$0).stopPreload(this.val$taskIdForTPProxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.2
 * JD-Core Version:    0.7.0.1
 */