package com.tencent.mobileqq.videoplatform;

import bbwm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class VideoPlayerProxy$1
  implements Runnable
{
  public VideoPlayerProxy$1(bbwm parambbwm, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (bbwm.a(this.this$0) != null)
      {
        if (this.a)
        {
          long l = (int)bbwm.a(this.this$0).getCurrentPositionMs();
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.a(), 2, "releasePlayer,record play pos = " + l);
          }
          if (bbwm.a(this.this$0) != null) {
            bbwm.a(this.this$0).c = l;
          }
        }
        bbwm.a(this.this$0).stop();
        bbwm.a(this.this$0).release();
        bbwm.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy.1
 * JD-Core Version:    0.7.0.1
 */