package com.tencent.tav.core;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;

public abstract interface AssetImageGenerator$ImageGeneratorListener
{
  public abstract void onCompletion(@NonNull CMTime paramCMTime1, @Nullable Bitmap paramBitmap, @Nullable CMTime paramCMTime2, @NonNull AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener
 * JD-Core Version:    0.7.0.1
 */