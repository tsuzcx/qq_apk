package com.tencent.widget.itemtouchhelper;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;

abstract interface GestureDetectorCompat$GestureDetectorCompatImpl
{
  public abstract boolean isLongpressEnabled();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setIsLongpressEnabled(boolean paramBoolean);
  
  public abstract void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.GestureDetectorCompat.GestureDetectorCompatImpl
 * JD-Core Version:    0.7.0.1
 */