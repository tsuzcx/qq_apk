package com.tencent.weseevideo.composition.image;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import java.util.List;

public abstract interface AssetImageGenerator$ImageGeneratorListener
{
  public abstract void onCompletion(@NonNull CMTime paramCMTime1, @Nullable Bitmap paramBitmap, @Nullable List<PointF> paramList, @Nullable CMTime paramCMTime2, @NonNull AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorListener
 * JD-Core Version:    0.7.0.1
 */