package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import atsu;

public class VideoFileViewer$1
  implements Runnable
{
  public VideoFileViewer$1(atsu paramatsu) {}
  
  public void run()
  {
    if (atsu.a(this.this$0).getVisibility() == 0)
    {
      Animation localAnimation = atsu.a(this.this$0).getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      atsu.a(this.this$0).clearAnimation();
    }
    atsu.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.1
 * JD-Core Version:    0.7.0.1
 */