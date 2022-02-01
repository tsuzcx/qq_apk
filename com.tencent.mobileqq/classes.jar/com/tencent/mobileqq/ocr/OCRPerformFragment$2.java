package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.util.WeakReferenceHandler;

class OCRPerformFragment$2
  implements Runnable
{
  OCRPerformFragment$2(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void run()
  {
    Bitmap localBitmap = OCRPerformUtil.a(OCRPerformFragment.b(this.this$0), this.this$0.getResources().getDisplayMetrics());
    OCRPerformFragment.c(this.this$0).obtainMessage(100, localBitmap).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.2
 * JD-Core Version:    0.7.0.1
 */