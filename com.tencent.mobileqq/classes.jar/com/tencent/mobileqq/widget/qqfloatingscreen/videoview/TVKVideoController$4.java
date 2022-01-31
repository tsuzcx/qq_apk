package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import aijm;
import betz;
import beuc;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public class TVKVideoController$4
  implements Runnable
{
  public TVKVideoController$4(betz parambetz) {}
  
  public void run()
  {
    if (betz.a(this.this$0) != null)
    {
      long l = betz.a(this.this$0).b();
      if (betz.a(this.this$0) != null) {
        betz.a(this.this$0).onVideoProgressUpdate((int)l);
      }
    }
    betz.a(this.this$0).postDelayed(this.this$0.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.4
 * JD-Core Version:    0.7.0.1
 */