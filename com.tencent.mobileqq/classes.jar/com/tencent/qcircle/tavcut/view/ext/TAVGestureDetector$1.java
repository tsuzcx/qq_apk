package com.tencent.qcircle.tavcut.view.ext;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class TAVGestureDetector$1
  implements ScaleGestureDetector.OnScaleGestureListener
{
  private float lastFocusX;
  private float lastFocusY = 0.0F;
  
  TAVGestureDetector$1(TAVGestureDetector paramTAVGestureDetector) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((!Float.isNaN(f)) && (!Float.isInfinite(f)))
    {
      if (f >= 0.0F)
      {
        TAVGestureDetector.access$000(this.this$0).onScale(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY(), paramScaleGestureDetector.getFocusX() - this.lastFocusX, paramScaleGestureDetector.getFocusY() - this.lastFocusY);
        this.lastFocusX = paramScaleGestureDetector.getFocusX();
        this.lastFocusY = paramScaleGestureDetector.getFocusY();
      }
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.lastFocusX = paramScaleGestureDetector.getFocusX();
    this.lastFocusY = paramScaleGestureDetector.getFocusY();
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.ext.TAVGestureDetector.1
 * JD-Core Version:    0.7.0.1
 */