package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.datasource.VideoDownloadListener;

class VideoProxy$6
  implements Runnable
{
  VideoProxy$6(VideoProxy paramVideoProxy, String paramString, VideoDownloadListener paramVideoDownloadListener, boolean paramBoolean, HttpHeader paramHttpHeader) {}
  
  public void run()
  {
    this.this$0.downloadVideoSync(this.val$url, this.val$listener, this.val$redownload, this.val$httpHeader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.6
 * JD-Core Version:    0.7.0.1
 */