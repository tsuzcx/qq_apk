package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnInfoListener;

class VideoPlayerProxyImpl$6
  implements TVK_IMediaPlayer.OnInfoListener
{
  VideoPlayerProxyImpl$6(VideoPlayerProxyImpl paramVideoPlayerProxyImpl, VideoPlayerProxy.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    return this.val$listener.onInfo(this.this$0, paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */