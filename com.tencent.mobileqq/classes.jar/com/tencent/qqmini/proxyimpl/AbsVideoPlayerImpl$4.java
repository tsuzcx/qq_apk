package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;

class AbsVideoPlayerImpl$4
  implements TVK_IMediaPlayer.OnCompletionListener
{
  AbsVideoPlayerImpl$4(AbsVideoPlayerImpl paramAbsVideoPlayerImpl, AbsVideoPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.onCompletion(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerImpl.4
 * JD-Core Version:    0.7.0.1
 */