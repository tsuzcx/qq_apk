package com.tencent.ttpic.filter.aifilter;

import android.graphics.Bitmap;
import com.microrapid.opencv.ImageAutoProcessor;
import java.util.concurrent.Semaphore;

class PhotoAIFilter$1
  implements Runnable
{
  PhotoAIFilter$1(PhotoAIFilter paramPhotoAIFilter, Bitmap paramBitmap1, Bitmap paramBitmap2, Semaphore paramSemaphore) {}
  
  public void run()
  {
    ImageAutoProcessor.nativeLightnessAuto(this.val$srcImage, this.val$lightResultBmp);
    PhotoAIFilter.access$002(this.this$0, true);
    this.val$lock.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.PhotoAIFilter.1
 * JD-Core Version:    0.7.0.1
 */