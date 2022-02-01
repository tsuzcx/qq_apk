package com.tencent.mobileqq.kandian.glue.viola.lottie;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class KdLottieView$3
  implements OnCompositionLoadedListener
{
  KdLottieView$3(KdLottieView paramKdLottieView, String paramString) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      this.b.setImageAssetsFolder(this.a);
      this.b.setComposition(paramLottieComposition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.lottie.KdLottieView.3
 * JD-Core Version:    0.7.0.1
 */