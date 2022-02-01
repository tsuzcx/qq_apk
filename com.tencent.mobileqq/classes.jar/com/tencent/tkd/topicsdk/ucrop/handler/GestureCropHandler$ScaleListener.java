package com.tencent.tkd.topicsdk.ucrop.handler;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

class GestureCropHandler$ScaleListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private GestureCropHandler$ScaleListener(GestureCropHandler paramGestureCropHandler) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.b(paramScaleGestureDetector.getScaleFactor(), GestureCropHandler.a(this.a), GestureCropHandler.b(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler.ScaleListener
 * JD-Core Version:    0.7.0.1
 */