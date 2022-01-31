package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnErrorListener;

class VideoPlayerProxyImpl$5
  implements TVK_IMediaPlayer.OnErrorListener
{
  VideoPlayerProxyImpl$5(VideoPlayerProxyImpl paramVideoPlayerProxyImpl, VideoPlayerProxy.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return this.val$listener.onError(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */