package com.tencent.mobileqq.videoplatform;

import bbvy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class VideoPlayerProxy$1
  implements Runnable
{
  public VideoPlayerProxy$1(bbvy parambbvy, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (bbvy.a(this.this$0) != null)
      {
        if (this.a)
        {
          long l = (int)bbvy.a(this.this$0).getCurrentPositionMs();
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.a(), 2, "releasePlayer,record play pos = " + l);
          }
          if (bbvy.a(this.this$0) != null) {
            bbvy.a(this.this$0).c = l;
          }
        }
        bbvy.a(this.this$0).stop();
        bbvy.a(this.this$0).release();
        bbvy.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy.1
 * JD-Core Version:    0.7.0.1
 */