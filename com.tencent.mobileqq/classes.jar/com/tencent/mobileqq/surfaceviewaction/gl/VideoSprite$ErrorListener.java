package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class VideoSprite$ErrorListener
  implements MediaPlayer.OnErrorListener
{
  private WeakReference<VideoSprite> a;
  
  private VideoSprite$ErrorListener(VideoSprite paramVideoSprite)
  {
    this.a = new WeakReference(paramVideoSprite);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (VideoSprite)this.a.get();
    if (paramMediaPlayer == null) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError: ");
      localStringBuilder.append(paramInt1);
      QLog.e("VideoSprite", 2, localStringBuilder.toString());
    }
    if (paramInt1 == 1)
    {
      if (paramMediaPlayer.ad != null) {
        paramMediaPlayer.ad.a();
      }
      paramMediaPlayer.w();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.ErrorListener
 * JD-Core Version:    0.7.0.1
 */