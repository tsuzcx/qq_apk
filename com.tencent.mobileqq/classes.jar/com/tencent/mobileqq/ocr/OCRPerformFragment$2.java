package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Message;
import ayfi;
import bkgm;

class OCRPerformFragment$2
  implements Runnable
{
  OCRPerformFragment$2(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void run()
  {
    Bitmap localBitmap = ayfi.a(OCRPerformFragment.a(this.this$0), this.this$0.getResources().getDisplayMetrics());
    this.this$0.a.obtainMessage(100, localBitmap).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.2
 * JD-Core Version:    0.7.0.1
 */