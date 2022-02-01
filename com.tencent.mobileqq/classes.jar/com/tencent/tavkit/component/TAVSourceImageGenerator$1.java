package com.tencent.tavkit.component;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.core.AssetImageGenerator.AssetImageGeneratorResult;
import com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener;
import com.tencent.tav.coremedia.CMTime;

class TAVSourceImageGenerator$1
  implements AssetImageGenerator.ImageGeneratorListener
{
  TAVSourceImageGenerator$1(TAVSourceImageGenerator paramTAVSourceImageGenerator, AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener) {}
  
  public void onCompletion(@NonNull CMTime paramCMTime1, @Nullable Bitmap paramBitmap, @Nullable CMTime paramCMTime2, @NonNull AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult)
  {
    this.val$imageGeneratorListener.onCompletion(paramCMTime1, paramBitmap, paramCMTime2, paramAssetImageGeneratorResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVSourceImageGenerator.1
 * JD-Core Version:    0.7.0.1
 */