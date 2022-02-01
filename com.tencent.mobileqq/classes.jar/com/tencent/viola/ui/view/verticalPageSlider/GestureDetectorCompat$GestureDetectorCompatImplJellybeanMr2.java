package com.tencent.viola.ui.view.verticalPageSlider;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2
  implements GestureDetectorCompat.GestureDetectorCompatImpl
{
  private final GestureDetector mDetector;
  
  public GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    this.mDetector = new GestureDetector(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.verticalPageSlider.GestureDetectorCompat.GestureDetectorCompatImplJellybeanMr2
 * JD-Core Version:    0.7.0.1
 */