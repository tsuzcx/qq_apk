package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import axcm;
import com.tencent.qphone.base.util.QLog;

public class VideoSprite$1$1
  implements Runnable
{
  public VideoSprite$1$1(axcm paramaxcm) {}
  
  public void run()
  {
    try
    {
      if (this.a.a.a != null) {
        this.a.a.a.start();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.1.1
 * JD-Core Version:    0.7.0.1
 */