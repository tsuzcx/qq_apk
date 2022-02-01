package com.tencent.mobileqq.winkpublish.widget.multitouchimg;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class CustomGestureDetector$1
  implements ScaleGestureDetector.OnScaleGestureListener
{
  CustomGestureDetector$1(CustomGestureDetector paramCustomGestureDetector) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((!Float.isNaN(f)) && (!Float.isInfinite(f)))
    {
      if (f >= 0.0F) {
        CustomGestureDetector.a(this.a).a(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      }
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if (CustomGestureDetector.b(this.a) != null) {
      CustomGestureDetector.b(this.a).a(f);
    }
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if (CustomGestureDetector.c(this.a) != null) {
      CustomGestureDetector.c(this.a).a(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.multitouchimg.CustomGestureDetector.1
 * JD-Core Version:    0.7.0.1
 */