package com.tencent.mobileqq.widget;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;

class TabDragAnimationView$1
  extends GestureDetector.SimpleOnGestureListener
{
  TabDragAnimationView$1(TabDragAnimationView paramTabDragAnimationView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (TabDragAnimationView.a(this.a) != null) {
      return TabDragAnimationView.a(this.a).onDoubleTap(paramMotionEvent);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
    if (TabDragAnimationView.b(this.a) != null) {
      TabDragAnimationView.b(this.a).onLongClick(this.a);
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (TabDragAnimationView.a(this.a) != null) {
      TabDragAnimationView.a(this.a).onSingleTapConfirmed(paramMotionEvent);
    }
    ViewParent localViewParent = this.a.getParent();
    if (localViewParent != null) {
      ((ViewGroup)localViewParent).performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView.1
 * JD-Core Version:    0.7.0.1
 */