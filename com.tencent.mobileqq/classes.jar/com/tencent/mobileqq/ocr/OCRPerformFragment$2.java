package com.tencent.mobileqq.ocr;

import android.graphics.Bitmap;
import android.os.Message;
import android.util.DisplayMetrics;
import auab;
import bfnk;

class OCRPerformFragment$2
  implements Runnable
{
  OCRPerformFragment$2(OCRPerformFragment paramOCRPerformFragment, DisplayMetrics paramDisplayMetrics) {}
  
  public void run()
  {
    Bitmap localBitmap = auab.a(OCRPerformFragment.a(this.this$0), this.a);
    this.this$0.a.obtainMessage(100, localBitmap).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.2
 * JD-Core Version:    0.7.0.1
 */