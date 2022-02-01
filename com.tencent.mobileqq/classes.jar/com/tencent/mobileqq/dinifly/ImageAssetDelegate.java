package com.tencent.mobileqq.dinifly;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

public abstract interface ImageAssetDelegate
{
  @Nullable
  public abstract Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.ImageAssetDelegate
 * JD-Core Version:    0.7.0.1
 */