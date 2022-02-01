package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class GiftBannerContainer$4
  implements Animator.AnimatorListener
{
  GiftBannerContainer$4(GiftBannerContainer paramGiftBannerContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator arg1)
  {
    synchronized (GiftBannerContainer.b(this.a))
    {
      QLog.i("Gift_Banner_Container", 1, "banner dismissed");
      GiftBannerContainer.a(this.a, 0);
      GiftBannerContainer.a(this.a).b();
      GiftBannerContainer.a(this.a).setVisibility(4);
      if (GiftBannerContainer.c(this.a) != null) {
        GiftBannerContainer.c(this.a).i();
      }
      return;
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.GiftBannerContainer.4
 * JD-Core Version:    0.7.0.1
 */