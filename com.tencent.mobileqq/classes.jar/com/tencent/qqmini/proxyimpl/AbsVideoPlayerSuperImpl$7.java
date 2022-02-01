package com.tencent.qqmini.proxyimpl;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;

class AbsVideoPlayerSuperImpl$7
  implements ISuperPlayer.OnCaptureImageListener
{
  AbsVideoPlayerSuperImpl$7(AbsVideoPlayerSuperImpl paramAbsVideoPlayerSuperImpl, AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener) {}
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    this.a.onCaptureImageFailed();
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.a.onCaptureImageSucceed(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerSuperImpl.7
 * JD-Core Version:    0.7.0.1
 */