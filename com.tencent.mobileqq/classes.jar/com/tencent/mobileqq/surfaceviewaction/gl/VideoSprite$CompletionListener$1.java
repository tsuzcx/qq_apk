package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import bcsn;
import com.tencent.qphone.base.util.QLog;

public class VideoSprite$CompletionListener$1
  implements Runnable
{
  public VideoSprite$CompletionListener$1(bcsn parambcsn, VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    try
    {
      if (this.a.a != null) {
        this.a.a.start();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "onCompletion: " + QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.CompletionListener.1
 * JD-Core Version:    0.7.0.1
 */