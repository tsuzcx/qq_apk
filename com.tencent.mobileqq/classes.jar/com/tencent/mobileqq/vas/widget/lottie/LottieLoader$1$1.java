package com.tencent.mobileqq.vas.widget.lottie;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

class LottieLoader$1$1
  implements ImageAssetDelegate
{
  LottieLoader$1$1(LottieLoader.1 param1) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (this.this$1.this$0.getMemoryCache() == null) {
      return null;
    }
    return (Bitmap)this.this$1.this$0.getMemoryCache().get(paramLottieImageAsset.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.widget.lottie.LottieLoader.1.1
 * JD-Core Version:    0.7.0.1
 */