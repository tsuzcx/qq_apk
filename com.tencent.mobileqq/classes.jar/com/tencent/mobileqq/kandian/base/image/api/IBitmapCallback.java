package com.tencent.mobileqq.kandian.base.image.api;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;

public abstract interface IBitmapCallback
{
  public abstract void a(ImageRequest paramImageRequest, int paramInt);
  
  public abstract void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap);
  
  public abstract void a(ImageRequest paramImageRequest, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback
 * JD-Core Version:    0.7.0.1
 */