package com.tencent.mobileqq.nearby.widget;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class OverCoverFrameLayout$1
  implements GestureDetector.OnGestureListener
{
  OverCoverFrameLayout$1(OverCoverFrameLayout paramOverCoverFrameLayout) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) <= this.a.i) {
      return false;
    }
    if ((this.a.l != null) && (this.a.l.a())) {
      return false;
    }
    if (paramFloat2 < 0.0F) {
      this.a.b();
    } else {
      this.a.c();
    }
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) <= this.a.h) {
      return false;
    }
    if ((this.a.l != null) && (this.a.l.a())) {
      return false;
    }
    if (paramFloat2 > 0.0F) {
      this.a.b();
    } else {
      this.a.c();
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout.1
 * JD-Core Version:    0.7.0.1
 */