package com.tencent.mobileqq.kandian.ad.api.impl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceHolder;

class RIJAdShakeManagerImpl$6
  implements MediaPlayer.OnPreparedListener
{
  RIJAdShakeManagerImpl$6(RIJAdShakeManagerImpl paramRIJAdShakeManagerImpl, SurfaceHolder paramSurfaceHolder) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i = paramMediaPlayer.getVideoWidth();
    int j = paramMediaPlayer.getVideoHeight();
    if ((i != 0) && (j != 0))
    {
      this.a.setFixedSize(i, j);
      paramMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdShakeManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */