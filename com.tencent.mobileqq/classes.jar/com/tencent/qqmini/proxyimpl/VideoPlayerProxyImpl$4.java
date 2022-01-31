package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCompletionListener;

class VideoPlayerProxyImpl$4
  implements TVK_IMediaPlayer.OnCompletionListener
{
  VideoPlayerProxyImpl$4(VideoPlayerProxyImpl paramVideoPlayerProxyImpl, VideoPlayerProxy.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.val$listener.onCompletion(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */