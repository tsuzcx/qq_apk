package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnVideoPreparedListener;

class VideoPlayerProxyImpl$3
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  VideoPlayerProxyImpl$3(VideoPlayerProxyImpl paramVideoPlayerProxyImpl, VideoPlayerProxy.OnVideoPreparedListener paramOnVideoPreparedListener) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.val$listener.onVideoPrepared(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */