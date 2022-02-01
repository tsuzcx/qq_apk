package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

final class SetSplash$6
  implements TVK_IMediaPlayer.OnErrorListener
{
  SetSplash$6(StartupDirector paramStartupDirector) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = new StringBuilder();
    paramTVK_IMediaPlayer.append("splash_logoerro+ errotype");
    paramTVK_IMediaPlayer.append(paramInt1);
    paramTVK_IMediaPlayer.append("errcode =");
    paramTVK_IMediaPlayer.append(paramInt2);
    QLog.i("QSplash@VasSplashUtil", 1, paramTVK_IMediaPlayer.toString());
    this.a.a(15, 1, 0L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.6
 * JD-Core Version:    0.7.0.1
 */