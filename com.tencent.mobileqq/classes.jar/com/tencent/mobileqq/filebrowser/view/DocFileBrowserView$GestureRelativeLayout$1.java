package com.tencent.mobileqq.filebrowser.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.filemanageraux.widget.DocCollectFormBanner;
import com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner;

class DocFileBrowserView$GestureRelativeLayout$1
  extends GestureDetector.SimpleOnGestureListener
{
  DocFileBrowserView$GestureRelativeLayout$1(DocFileBrowserView.GestureRelativeLayout paramGestureRelativeLayout, DocFileBrowserView paramDocFileBrowserView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
    {
      paramMotionEvent1 = this.b.a.d();
      if (paramFloat2 > 0.0F)
      {
        if (paramMotionEvent1 != null) {
          paramMotionEvent1.setVisibility(8);
        }
        if (this.b.a.a != null) {
          this.b.a.a.b(true);
        }
        if (this.b.a.b != null)
        {
          this.b.a.b.b(true);
          return true;
        }
      }
      else
      {
        if (paramMotionEvent1 != null) {
          paramMotionEvent1.setVisibility(0);
        }
        if (this.b.a.a != null) {
          this.b.a.a.a(true);
        }
        if (this.b.a.b != null) {
          this.b.a.b.a(true);
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.GestureRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */