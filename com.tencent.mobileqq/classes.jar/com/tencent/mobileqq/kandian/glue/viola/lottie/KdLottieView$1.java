package com.tencent.mobileqq.kandian.glue.viola.lottie;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.viola.ui.component.VLottie.IVLottieLoadListener;

class KdLottieView$1
  implements OnCompositionLoadedListener
{
  KdLottieView$1(KdLottieView paramKdLottieView, VLottie.IVLottieLoadListener paramIVLottieLoadListener) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaLottieKdLottieView.setComposition(paramLottieComposition);
      paramLottieComposition = this.jdField_a_of_type_ComTencentViolaUiComponentVLottie$IVLottieLoadListener;
      if (paramLottieComposition != null) {
        paramLottieComposition.onResult(true);
      }
    }
    else
    {
      paramLottieComposition = this.jdField_a_of_type_ComTencentViolaUiComponentVLottie$IVLottieLoadListener;
      if (paramLottieComposition != null) {
        paramLottieComposition.onResult(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.lottie.KdLottieView.1
 * JD-Core Version:    0.7.0.1
 */