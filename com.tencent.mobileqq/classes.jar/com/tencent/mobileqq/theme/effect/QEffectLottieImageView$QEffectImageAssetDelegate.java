package com.tencent.mobileqq.theme.effect;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

class QEffectLottieImageView$QEffectImageAssetDelegate
  implements ImageAssetDelegate
{
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (GlobalImageCache.a != null) {
      return (Bitmap)GlobalImageCache.a.get(paramLottieImageAsset.getKey());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.effect.QEffectLottieImageView.QEffectImageAssetDelegate
 * JD-Core Version:    0.7.0.1
 */