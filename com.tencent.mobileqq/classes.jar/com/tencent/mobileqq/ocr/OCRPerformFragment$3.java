package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ocr.view.EyeButton.EyeButtonLonTouchListener;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;

class OCRPerformFragment$3
  implements EyeButton.EyeButtonLonTouchListener
{
  OCRPerformFragment$3(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void a()
  {
    OCRPerformUtil.a("0X800AAE1", 0);
    if (OCRPerformFragment.d(this.a).a()) {
      OCRPerformFragment.d(this.a).setShowTextMask(false);
    }
  }
  
  public void b()
  {
    if (!OCRPerformFragment.d(this.a).a()) {
      OCRPerformFragment.d(this.a).setShowTextMask(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.3
 * JD-Core Version:    0.7.0.1
 */