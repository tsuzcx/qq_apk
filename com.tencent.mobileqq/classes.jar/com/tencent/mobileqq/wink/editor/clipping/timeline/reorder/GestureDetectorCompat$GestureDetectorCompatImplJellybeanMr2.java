package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2
  implements GestureDetectorCompat.GestureDetectorCompatImpl
{
  private final GestureDetector a;
  
  public GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    this.a = new GestureDetector(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.a.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.GestureDetectorCompat.GestureDetectorCompatImplJellybeanMr2
 * JD-Core Version:    0.7.0.1
 */