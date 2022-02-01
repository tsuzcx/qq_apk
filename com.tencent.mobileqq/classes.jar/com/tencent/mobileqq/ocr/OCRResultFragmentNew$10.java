package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;

class OCRResultFragmentNew$10
  extends PicOcrObserver
{
  OCRResultFragmentNew$10(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  protected void a(boolean paramBoolean, PicOcrRspResult paramPicOcrRspResult)
  {
    if (!OCRResultFragmentNew.a(this.a)) {
      return;
    }
    OCRResultFragmentNew.b(this.a, false);
    OCRResultFragmentNew.a(this.a).runOnUiThread(new OCRResultFragmentNew.10.1(this, paramBoolean, paramPicOcrRspResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.10
 * JD-Core Version:    0.7.0.1
 */