package com.tencent.mobileqq.qqlive.widget;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

class PortraitImageView$MyGestureListener
  extends PortraitImageView.SimpleOnGestureListener
{
  private PortraitImageView$MyGestureListener(PortraitImageView paramPortraitImageView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (((paramMotionEvent1 != null) && (paramMotionEvent1.getPointerCount() > 1)) || ((paramMotionEvent2 != null) && (paramMotionEvent2.getPointerCount() > 1)) || ((this.a.b != null) && (this.a.b.isInProgress()))) {
      return false;
    }
    paramMotionEvent1 = this.a;
    paramMotionEvent1.removeCallbacks(paramMotionEvent1.a);
    this.a.a(-paramFloat1, -paramFloat2);
    paramMotionEvent1 = this.a;
    paramMotionEvent1.setImageMatrix(paramMotionEvent1.getImageViewMatrix());
    if ((this.a.k != null) && (!this.a.s))
    {
      this.a.k.a();
      this.a.s = true;
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a.j != null)
    {
      this.a.j.a();
      return false;
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.widget.PortraitImageView.MyGestureListener
 * JD-Core Version:    0.7.0.1
 */