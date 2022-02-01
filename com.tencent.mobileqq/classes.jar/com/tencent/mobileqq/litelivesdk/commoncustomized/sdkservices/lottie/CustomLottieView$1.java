package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie;

import android.graphics.Bitmap;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

class CustomLottieView$1
  implements ImageAssetDelegate
{
  CustomLottieView$1(CustomLottieView paramCustomLottieView) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    CustomLottieView localCustomLottieView = this.a;
    return CustomLottieView.a(localCustomLottieView, localCustomLottieView.getContext(), paramLottieImageAsset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieView.1
 * JD-Core Version:    0.7.0.1
 */