package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;

class AbsVideoPlayerSuperImpl$4
  implements ISuperPlayer.OnErrorListener
{
  AbsVideoPlayerSuperImpl$4(AbsVideoPlayerSuperImpl paramAbsVideoPlayerSuperImpl, AbsVideoPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    return this.a.onError(this.b, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerSuperImpl.4
 * JD-Core Version:    0.7.0.1
 */