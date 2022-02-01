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
    if (Math.abs(paramFloat2) <= this.a.e) {
      return false;
    }
    if ((this.a.a != null) && (this.a.a.a())) {
      return false;
    }
    if (paramFloat2 < 0.0F) {
      this.a.a();
    } else {
      this.a.b();
    }
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) <= this.a.d) {
      return false;
    }
    if ((this.a.a != null) && (this.a.a.a())) {
      return false;
    }
    if (paramFloat2 > 0.0F) {
      this.a.a();
    } else {
      this.a.b();
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout.1
 * JD-Core Version:    0.7.0.1
 */