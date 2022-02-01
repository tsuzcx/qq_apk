package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

final class SetSplash$4
  implements TVK_IMediaPlayer.OnErrorListener
{
  SetSplash$4(StartupDirector paramStartupDirector) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.i("SplashMiniGameStarter", 1, "splash_logoerro+ errotype" + paramInt1 + "errcode =" + paramInt2);
    this.a.a(15, 1, 0L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.4
 * JD-Core Version:    0.7.0.1
 */