package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;

class VideoFileViewer$4
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoFileViewer$4(VideoFileViewer paramVideoFileViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((VideoFileViewer.c(this.a).getVisibility() == 0) && (Math.abs(VideoFileViewer.c(this.a).getAlpha() - f) >= 0.02F)) {
        VideoFileViewer.c(this.a).setAlpha(f);
      }
      if ((VideoFileViewer.c(this.a).getVisibility() == 0) && (Math.abs(VideoFileViewer.c(this.a).getAlpha() - f) >= 0.02F)) {
        VideoFileViewer.c(this.a).setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.4
 * JD-Core Version:    0.7.0.1
 */