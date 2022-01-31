package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnSeekCompleteListener;

class VideoPlayerProxyImpl$7
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  VideoPlayerProxyImpl$7(VideoPlayerProxyImpl paramVideoPlayerProxyImpl, VideoPlayerProxy.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.val$listener.onSeekComplete(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */