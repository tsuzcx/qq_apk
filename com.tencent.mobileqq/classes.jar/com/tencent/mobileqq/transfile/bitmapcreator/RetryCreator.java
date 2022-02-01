package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;

public class RetryCreator
  implements BitmapCreator
{
  int retryTime;
  
  public RetryCreator(int paramInt)
  {
    this.retryTime = paramInt;
    if (this.retryTime <= 0) {}
  }
  
  public Bitmap creatBitmap(Bitmap paramBitmap)
  {
    while (this.retryTime < 0) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.RetryCreator
 * JD-Core Version:    0.7.0.1
 */