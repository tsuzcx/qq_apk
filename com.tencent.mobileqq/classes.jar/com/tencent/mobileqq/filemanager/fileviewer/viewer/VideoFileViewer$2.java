package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aron;

public class VideoFileViewer$2
  implements Runnable
{
  public VideoFileViewer$2(aron paramaron) {}
  
  public void run()
  {
    if (aron.a(this.this$0).getVisibility() == 0)
    {
      Animation localAnimation = aron.a(this.this$0).getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      aron.a(this.this$0).clearAnimation();
    }
    aron.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.2
 * JD-Core Version:    0.7.0.1
 */