package com.tencent.mobileqq.olympic.activity;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class PromotionGuide$1
  implements OnCompositionLoadedListener
{
  PromotionGuide$1(PromotionGuide paramPromotionGuide, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setImageAssetDelegate(new PromotionGuide.1.1(this));
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    PromotionGuide.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide).setImageDrawable(localLottieDrawable);
    PromotionGuide.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide, localLottieDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionGuide.1
 * JD-Core Version:    0.7.0.1
 */