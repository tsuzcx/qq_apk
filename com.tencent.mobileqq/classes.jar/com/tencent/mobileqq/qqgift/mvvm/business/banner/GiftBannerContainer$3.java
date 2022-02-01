package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class GiftBannerContainer$3
  implements ValueAnimator.AnimatorUpdateListener
{
  GiftBannerContainer$3(GiftBannerContainer paramGiftBannerContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    GiftBannerContainer.a(this.a).setTranslationX(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.GiftBannerContainer.3
 * JD-Core Version:    0.7.0.1
 */