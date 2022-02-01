package com.tencent.mobileqq.kandian.glue.viola.lottie;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class KdLottieView$2$1
  implements OnCompositionLoadedListener
{
  KdLottieView$2$1(KdLottieView.2 param2) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaLottieKdLottieView.setImageAssetsFolder(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaLottieKdLottieView.setComposition(paramLottieComposition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.lottie.KdLottieView.2.1
 * JD-Core Version:    0.7.0.1
 */