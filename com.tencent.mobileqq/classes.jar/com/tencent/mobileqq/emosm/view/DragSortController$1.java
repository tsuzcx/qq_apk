package com.tencent.mobileqq.emosm.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class DragSortController$1
  extends GestureDetector.SimpleOnGestureListener
{
  DragSortController$1(DragSortController paramDragSortController) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((!this.a.i.d()) && (this.a.k != -1)) {
      this.a.i.setTapPos(this.a.k);
    }
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!this.a.i.d()) && (Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (!this.a.i.e()) && (!this.a.h) && (Math.abs(paramFloat1) > this.a.j))
    {
      if ((paramFloat1 < 0.0F) && (this.a.a == 2)) {
        return false;
      }
      if ((paramFloat1 > 0.0F) && (this.a.a == 1)) {
        return false;
      }
      int i = this.a.k;
      this.a.i.setSrcPos(i);
      this.a.i.f();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortController.1
 * JD-Core Version:    0.7.0.1
 */