package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import akjs;
import bixb;
import bixe;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public class TVKVideoController$4
  implements Runnable
{
  public TVKVideoController$4(bixb parambixb) {}
  
  public void run()
  {
    if (bixb.a(this.this$0) != null)
    {
      long l = bixb.a(this.this$0).b();
      if (bixb.a(this.this$0) != null) {
        bixb.a(this.this$0).onVideoProgressUpdate((int)l);
      }
    }
    bixb.a(this.this$0).postDelayed(this.this$0.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.4
 * JD-Core Version:    0.7.0.1
 */