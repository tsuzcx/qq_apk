package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.widget.DragView.OnGestureChangeListener;

class VideoFileViewer$5
  implements DragView.OnGestureChangeListener
{
  VideoFileViewer$5(VideoFileViewer paramVideoFileViewer) {}
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    VideoFileViewer.a(this.a, true);
    Drawable localDrawable;
    if (VideoFileViewer.g(this.a) != null)
    {
      localDrawable = VideoFileViewer.g(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (VideoFileViewer.h(this.a) != null)
    {
      localDrawable = VideoFileViewer.h(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      VideoFileViewer.c(this.a).setVisibility(8);
      VideoFileViewer.i(this.a).setVisibility(8);
      this.a.d.setVisibility(8);
    }
  }
  
  public void onGestureFinish()
  {
    VideoFileViewer.a(this.a, false);
    this.a.j.s();
    this.a.c.overridePendingTransition(0, 0);
  }
  
  public void onResetPosition()
  {
    VideoFileViewer.a(this.a, false);
    if (VideoFileViewer.d(this.a)) {
      this.a.f(true);
    }
    if (VideoFileViewer.e(this.a)) {
      this.a.g(true);
    }
    if (VideoFileViewer.f(this.a)) {
      this.a.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.5
 * JD-Core Version:    0.7.0.1
 */