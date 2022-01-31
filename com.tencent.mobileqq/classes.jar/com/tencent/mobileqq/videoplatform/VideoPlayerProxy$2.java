package com.tencent.mobileqq.videoplatform;

import bbvy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class VideoPlayerProxy$2
  implements Runnable
{
  public VideoPlayerProxy$2(bbvy parambbvy) {}
  
  public void run()
  {
    try
    {
      if ((bbvy.a(this.this$0) != null) && (bbvy.a(this.this$0).isPlaying()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.a(), 2, "mMediaPlayer.pause()");
        }
        bbvy.a(this.this$0).pause();
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