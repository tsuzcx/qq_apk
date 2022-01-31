package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import agai;
import bbra;
import bbrd;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public class TVKVideoController$4
  implements Runnable
{
  public TVKVideoController$4(bbra parambbra) {}
  
  public void run()
  {
    if (bbra.a(this.this$0) != null)
    {
      long l = bbra.a(this.this$0).b();
      if (bbra.a(this.this$0) != null) {
        bbra.a(this.this$0).onVideoProgressUpdate((int)l);
      }
    }
    bbra.a(this.this$0).postDelayed(this.this$0.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.4
 * JD-Core Version:    0.7.0.1
 */