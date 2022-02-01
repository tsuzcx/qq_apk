package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

final class SetSplash$8
  implements TVK_IMediaPlayer.OnCompletionListener
{
  SetSplash$8(StartupDirector paramStartupDirector) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "video finish");
    this.a.a(15, 1, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.8
 * JD-Core Version:    0.7.0.1
 */