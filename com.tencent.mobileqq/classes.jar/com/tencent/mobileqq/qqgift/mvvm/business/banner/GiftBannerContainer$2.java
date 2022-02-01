package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.qphone.base.util.QLog;

class GiftBannerContainer$2
  implements Animator.AnimatorListener
{
  GiftBannerContainer$2(GiftBannerContainer paramGiftBannerContainer, GiftAnimData paramGiftAnimData) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator arg1)
  {
    synchronized (GiftBannerContainer.b(this.b))
    {
      QLog.i("Gift_Banner_Container", 1, "banner showed");
      GiftBannerContainer.a(this.b, 2);
      GiftBannerContainer.a(this.b).a(this.b);
      GiftBannerContainer.a(this.b).a(this.a.o);
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
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.GiftBannerContainer.2
 * JD-Core Version:    0.7.0.1
 */