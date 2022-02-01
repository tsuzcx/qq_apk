package com.tencent.mobileqq.ocr;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.tencent.mobileqq.ocr.view.gesture.control.SimpleOnGestureListener;

class OCRResultFragmentNew$1
  extends SimpleOnGestureListener
{
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  OCRResultFragmentNew$1(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    if ((this.jdField_a_of_type_Boolean) || (this.b)) {
      OCRPerformUtil.a("0X800AC97", 0);
    }
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.b = true;
    return super.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.1
 * JD-Core Version:    0.7.0.1
 */