package com.tencent.mobileqq.ocr;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.tencent.mobileqq.ocr.view.gesture.control.SimpleOnGestureListener;

class OCRResultFragmentNew$1
  extends SimpleOnGestureListener
{
  private boolean b;
  private boolean c;
  
  OCRResultFragmentNew$1(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    if ((this.b) || (this.c)) {
      OCRPerformUtil.a("0X800AC97", 0);
    }
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.b = true;
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.c = true;
    return super.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.1
 * JD-Core Version:    0.7.0.1
 */