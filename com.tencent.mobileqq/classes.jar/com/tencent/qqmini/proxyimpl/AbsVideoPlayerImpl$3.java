package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;

class AbsVideoPlayerImpl$3
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  AbsVideoPlayerImpl$3(AbsVideoPlayerImpl paramAbsVideoPlayerImpl, AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.onVideoPrepared(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerImpl.3
 * JD-Core Version:    0.7.0.1
 */