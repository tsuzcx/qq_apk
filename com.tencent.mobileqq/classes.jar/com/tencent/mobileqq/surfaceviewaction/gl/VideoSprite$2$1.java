package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class VideoSprite$2$1
  implements MediaPlayer.OnSeekCompleteListener
{
  VideoSprite$2$1(VideoSprite.2 param2) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    try
    {
      this.a.this$0.ac.start();
      this.a.this$0.ah = true;
      if (this.a.this$0.L != null) {
        this.a.this$0.ak.postDelayed(this.a.this$0, 33L);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playVideo: ");
        localStringBuilder.append(QLog.getStackTraceString(paramMediaPlayer));
        QLog.e("VideoSprite", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.2.1
 * JD-Core Version:    0.7.0.1
 */