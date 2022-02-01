package com.tencent.qqmini.sdk.launcher.widget;

import android.view.MotionEvent;

public abstract interface VideoGestureRelativeLayout$VideoGestureListener
{
  public abstract void onBrightnessGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  
  public abstract void onDoubleTapGesture(MotionEvent paramMotionEvent);
  
  public abstract void onDown(MotionEvent paramMotionEvent);
  
  public abstract void onEndFF_REW(MotionEvent paramMotionEvent);
  
  public abstract void onProgressGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  
  public abstract void onSingleTapGesture(MotionEvent paramMotionEvent);
  
  public abstract void onVolumeGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener
 * JD-Core Version:    0.7.0.1
 */