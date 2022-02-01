package com.tencent.mobileqq.kandian.glue.viola.lottie;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.viola.ui.component.VLottie.IVLottieLoadListener;

class KdLottieView$2
  implements OnCompositionLoadedListener
{
  KdLottieView$2(KdLottieView paramKdLottieView, VLottie.IVLottieLoadListener paramIVLottieLoadListener) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      this.b.setComposition(paramLottieComposition);
      paramLottieComposition = this.a;
      if (paramLottieComposition != null) {
        paramLottieComposition.onResult(true);
      }
    }
    else
    {
      paramLottieComposition = this.a;
      if (paramLottieComposition != null) {
        paramLottieComposition.onResult(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.lottie.KdLottieView.2
 * JD-Core Version:    0.7.0.1
 */