package com.tencent.tavcut.view.ext;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class TAVGestureDetector$1
  implements ScaleGestureDetector.OnScaleGestureListener
{
  private float jdField_a_of_type_Float;
  private float b = 0.0F;
  
  TAVGestureDetector$1(TAVGestureDetector paramTAVGestureDetector) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((!Float.isNaN(f)) && (!Float.isInfinite(f)))
    {
      if (f >= 0.0F)
      {
        TAVGestureDetector.a(this.jdField_a_of_type_ComTencentTavcutViewExtTAVGestureDetector).a(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY(), paramScaleGestureDetector.getFocusX() - this.jdField_a_of_type_Float, paramScaleGestureDetector.getFocusY() - this.b);
        this.jdField_a_of_type_Float = paramScaleGestureDetector.getFocusX();
        this.b = paramScaleGestureDetector.getFocusY();
      }
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Float = paramScaleGestureDetector.getFocusX();
    this.b = paramScaleGestureDetector.getFocusY();
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.view.ext.TAVGestureDetector.1
 * JD-Core Version:    0.7.0.1
 */