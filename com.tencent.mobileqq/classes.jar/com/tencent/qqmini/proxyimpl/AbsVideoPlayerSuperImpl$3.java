package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;

class AbsVideoPlayerSuperImpl$3
  implements ISuperPlayer.OnCompletionListener
{
  AbsVideoPlayerSuperImpl$3(AbsVideoPlayerSuperImpl paramAbsVideoPlayerSuperImpl, AbsVideoPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.a.onCompletion(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerSuperImpl.3
 * JD-Core Version:    0.7.0.1
 */