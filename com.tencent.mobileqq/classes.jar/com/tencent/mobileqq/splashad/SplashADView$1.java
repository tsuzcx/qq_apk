package com.tencent.mobileqq.splashad;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import mqq.os.MqqHandler;

class SplashADView$1
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  SplashADView$1(SplashADView paramSplashADView) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().postDelayed(new SplashADView.1.1(this), 200L);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView.1
 * JD-Core Version:    0.7.0.1
 */