package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class VideoSprite$PreparedListener
  implements MediaPlayer.OnPreparedListener
{
  private WeakReference<VideoSprite> a;
  
  private VideoSprite$PreparedListener(VideoSprite paramVideoSprite)
  {
    this.a = new WeakReference(paramVideoSprite);
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = (VideoSprite)this.a.get();
    if (paramMediaPlayer == null) {
      return;
    }
    try
    {
      paramMediaPlayer.af = paramMediaPlayer.ac.getVideoWidth();
      paramMediaPlayer.ag = paramMediaPlayer.ac.getVideoHeight();
      paramMediaPlayer.ac.start();
      paramMediaPlayer.ah = true;
      if (paramMediaPlayer.L != null)
      {
        paramMediaPlayer.ak.postDelayed(paramMediaPlayer, 33L);
        return;
      }
    }
    catch (Exception paramMediaPlayer)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playVideo Exception: ");
        localStringBuilder.append(QLog.getStackTraceString(paramMediaPlayer));
        QLog.e("VideoSprite", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.PreparedListener
 * JD-Core Version:    0.7.0.1
 */