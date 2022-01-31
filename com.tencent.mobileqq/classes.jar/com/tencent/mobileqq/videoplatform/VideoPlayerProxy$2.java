package com.tencent.mobileqq.videoplatform;

import bbwm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class VideoPlayerProxy$2
  implements Runnable
{
  public VideoPlayerProxy$2(bbwm parambbwm) {}
  
  public void run()
  {
    try
    {
      if ((bbwm.a(this.this$0) != null) && (bbwm.a(this.this$0).isPlaying()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.a(), 2, "mMediaPlayer.pause()");
        }
        bbwm.a(this.this$0).pause();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy.2
 * JD-Core Version:    0.7.0.1
 */