package com.tencent.mobileqq.filemanager.fileviewer;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class FileBrowserActivity$2
  extends GestureDetector.SimpleOnGestureListener
{
  FileBrowserActivity$2(FileBrowserActivity paramFileBrowserActivity, int paramInt) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
      if ((paramFloat1 <= -this.a) && (paramFloat2 < 0.5F) && (this.b.d != null) && (this.b.d.e())) {
        return this.b.onBackEvent();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.2
 * JD-Core Version:    0.7.0.1
 */