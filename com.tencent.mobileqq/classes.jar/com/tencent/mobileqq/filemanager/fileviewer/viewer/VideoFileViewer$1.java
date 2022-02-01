package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

class VideoFileViewer$1
  implements Runnable
{
  VideoFileViewer$1(VideoFileViewer paramVideoFileViewer) {}
  
  public void run()
  {
    if (VideoFileViewer.a(this.this$0).getVisibility() == 0)
    {
      Animation localAnimation = VideoFileViewer.a(this.this$0).getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      VideoFileViewer.a(this.this$0).clearAnimation();
    }
    VideoFileViewer.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.1
 * JD-Core Version:    0.7.0.1
 */