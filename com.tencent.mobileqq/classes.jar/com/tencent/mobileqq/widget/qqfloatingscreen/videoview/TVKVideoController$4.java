package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import aiob;
import beyi;
import beyl;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public class TVKVideoController$4
  implements Runnable
{
  public TVKVideoController$4(beyi parambeyi) {}
  
  public void run()
  {
    if (beyi.a(this.this$0) != null)
    {
      long l = beyi.a(this.this$0).b();
      if (beyi.a(this.this$0) != null) {
        beyi.a(this.this$0).onVideoProgressUpdate((int)l);
      }
    }
    beyi.a(this.this$0).postDelayed(this.this$0.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.4
 * JD-Core Version:    0.7.0.1
 */