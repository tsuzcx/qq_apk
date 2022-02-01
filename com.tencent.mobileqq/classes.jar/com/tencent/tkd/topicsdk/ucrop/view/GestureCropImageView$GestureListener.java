package com.tencent.tkd.topicsdk.ucrop.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class GestureCropImageView$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private GestureCropImageView$GestureListener(GestureCropImageView paramGestureCropImageView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    GestureCropImageView localGestureCropImageView = this.a;
    localGestureCropImageView.a(localGestureCropImageView.c(), paramMotionEvent.getX(), paramMotionEvent.getY(), 200L);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.a.a(-paramFloat1, -paramFloat2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.GestureCropImageView.GestureListener
 * JD-Core Version:    0.7.0.1
 */