package com.tencent.weseevideo.composition.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;

class AssetImageGenerator$DefaultBitmapFactory
  implements AssetImageGenerator.OutputBitmapFactory
{
  @NonNull
  public Bitmap getOutputBitmap(int paramInt1, int paramInt2)
  {
    return Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.image.AssetImageGenerator.DefaultBitmapFactory
 * JD-Core Version:    0.7.0.1
 */