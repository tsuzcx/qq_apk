package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import ajoe;
import bhml;
import bhmo;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public class TVKVideoController$4
  implements Runnable
{
  public TVKVideoController$4(bhml parambhml) {}
  
  public void run()
  {
    if (bhml.a(this.this$0) != null)
    {
      long l = bhml.a(this.this$0).b();
      if (bhml.a(this.this$0) != null) {
        bhml.a(this.this$0).onVideoProgressUpdate((int)l);
      }
    }
    bhml.a(this.this$0).postDelayed(this.this$0.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.4
 * JD-Core Version:    0.7.0.1
 */