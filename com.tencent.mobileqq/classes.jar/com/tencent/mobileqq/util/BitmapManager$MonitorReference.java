package com.tencent.mobileqq.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class BitmapManager$MonitorReference<Bitmap>
  extends WeakReference<Bitmap>
{
  private final String a;
  
  public BitmapManager$MonitorReference(String paramString, Bitmap paramBitmap, ReferenceQueue paramReferenceQueue)
  {
    super(paramBitmap, paramReferenceQueue);
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.BitmapManager.MonitorReference
 * JD-Core Version:    0.7.0.1
 */