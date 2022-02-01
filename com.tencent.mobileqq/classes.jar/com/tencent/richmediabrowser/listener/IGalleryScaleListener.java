package com.tencent.richmediabrowser.listener;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public abstract interface IGalleryScaleListener
{
  public abstract boolean onDoubleTap(MotionEvent paramMotionEvent);
  
  public abstract boolean onScale(ScaleGestureDetector paramScaleGestureDetector);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.listener.IGalleryScaleListener
 * JD-Core Version:    0.7.0.1
 */