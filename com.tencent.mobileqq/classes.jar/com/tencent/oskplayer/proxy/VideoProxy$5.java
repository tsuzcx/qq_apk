package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.datasource.DownloadListener;
import com.tencent.oskplayer.datasource.HttpHeader;

class VideoProxy$5
  implements Runnable
{
  VideoProxy$5(VideoProxy paramVideoProxy, String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, HttpHeader paramHttpHeader, DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    this.this$0.preloadSync(this.val$originalUrl, this.val$bytes, this.val$videoDurationMs, this.val$preloadDurationMs, this.val$needPreloadStart, this.val$needPreloadEnd, this.val$extraHeader, this.val$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.5
 * JD-Core Version:    0.7.0.1
 */