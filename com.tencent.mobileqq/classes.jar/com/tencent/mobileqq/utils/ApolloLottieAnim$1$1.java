package com.tencent.mobileqq.utils;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

class ApolloLottieAnim$1$1
  implements ImageAssetDelegate
{
  ApolloLottieAnim$1$1(ApolloLottieAnim.1 param1) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (this.a.a.a() == null) {
      return null;
    }
    return (Bitmap)this.a.a.a().get(paramLottieImageAsset.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ApolloLottieAnim.1.1
 * JD-Core Version:    0.7.0.1
 */