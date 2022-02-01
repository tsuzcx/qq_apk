package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;

class AbsVideoPlayerImpl$5
  implements TVK_IMediaPlayer.OnErrorListener
{
  AbsVideoPlayerImpl$5(AbsVideoPlayerImpl paramAbsVideoPlayerImpl, AbsVideoPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return this.a.onError(this.b, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerImpl.5
 * JD-Core Version:    0.7.0.1
 */