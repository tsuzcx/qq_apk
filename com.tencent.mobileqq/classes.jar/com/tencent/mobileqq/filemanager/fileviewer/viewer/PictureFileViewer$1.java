package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.widget.DragView.OnGestureChangeListener;

class PictureFileViewer$1
  implements DragView.OnGestureChangeListener
{
  PictureFileViewer$1(PictureFileViewer paramPictureFileViewer) {}
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    PictureFileViewer.a(this.a, true);
    if (PictureFileViewer.c(this.a) != null)
    {
      Drawable localDrawable = PictureFileViewer.c(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (PictureFileViewer.d(this.a) != null) {
        PictureFileViewer.d(this.a).setVisibility(8);
      }
      if (this.a.d != null) {
        this.a.d.setVisibility(8);
      }
    }
  }
  
  public void onGestureFinish()
  {
    PictureFileViewer.a(this.a, false);
    this.a.j.s();
  }
  
  public void onResetPosition()
  {
    PictureFileViewer.a(this.a, false);
    if (PictureFileViewer.a(this.a)) {
      this.a.b(true);
    }
    if (PictureFileViewer.b(this.a)) {
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer.1
 * JD-Core Version:    0.7.0.1
 */