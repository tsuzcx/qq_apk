package com.tencent.mobileqq.util;

import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

class ImageWorker$AsyncDrawable
  extends BitmapDrawable
{
  private final WeakReference<ImageWorker.BitmapWorkerTask> a;
  
  public ImageWorker.BitmapWorkerTask a()
  {
    return (ImageWorker.BitmapWorkerTask)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker.AsyncDrawable
 * JD-Core Version:    0.7.0.1
 */