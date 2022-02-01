package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;

class AbsVideoPlayerImpl$6
  implements TVK_IMediaPlayer.OnInfoListener
{
  AbsVideoPlayerImpl$6(AbsVideoPlayerImpl paramAbsVideoPlayerImpl, AbsVideoPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    return this.a.onInfo(this.b, paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerImpl.6
 * JD-Core Version:    0.7.0.1
 */