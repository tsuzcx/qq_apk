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
    if (PictureFileViewer.a(this.a) != null)
    {
      Drawable localDrawable = PictureFileViewer.a(this.a).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (PictureFileViewer.a(this.a) != null) {
        PictureFileViewer.a(this.a).setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void onGestureFinish()
  {
    PictureFileViewer.a(this.a, false);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase$CloseFileBrowserCallback.o();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer.1
 * JD-Core Version:    0.7.0.1
 */