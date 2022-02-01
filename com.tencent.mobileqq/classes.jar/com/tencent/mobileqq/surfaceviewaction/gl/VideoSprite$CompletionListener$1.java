package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;

class VideoSprite$CompletionListener$1
  implements Runnable
{
  VideoSprite$CompletionListener$1(VideoSprite.CompletionListener paramCompletionListener, VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    try
    {
      if (this.a.a != null)
      {
        this.a.a.start();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCompletion: ");
        localStringBuilder.append(QLog.getStackTraceString(localException));
        QLog.e("VideoSprite", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.CompletionListener.1
 * JD-Core Version:    0.7.0.1
 */