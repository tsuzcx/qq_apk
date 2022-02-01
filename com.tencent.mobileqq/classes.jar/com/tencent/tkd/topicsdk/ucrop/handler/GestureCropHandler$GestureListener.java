package com.tencent.tkd.topicsdk.ucrop.handler;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class GestureCropHandler$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private GestureCropHandler$GestureListener(GestureCropHandler paramGestureCropHandler) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    GestureCropHandler localGestureCropHandler = this.a;
    localGestureCropHandler.a(localGestureCropHandler.g(), paramMotionEvent.getX(), paramMotionEvent.getY(), 200L);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.a.a(-paramFloat1, -paramFloat2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler.GestureListener
 * JD-Core Version:    0.7.0.1
 */