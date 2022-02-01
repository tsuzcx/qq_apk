package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import akev;
import bifg;
import bifj;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public class TVKVideoController$4
  implements Runnable
{
  public TVKVideoController$4(bifg parambifg) {}
  
  public void run()
  {
    if (bifg.a(this.this$0) != null)
    {
      long l = bifg.a(this.this$0).b();
      if (bifg.a(this.this$0) != null) {
        bifg.a(this.this$0).onVideoProgressUpdate((int)l);
      }
    }
    bifg.a(this.this$0).postDelayed(this.this$0.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.4
 * JD-Core Version:    0.7.0.1
 */