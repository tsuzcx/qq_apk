package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper.LottieDrawableLoadedListener;

class OnLineStatusCustomSmartViewCtrl$1
  implements LottieHelper.LottieDrawableLoadedListener
{
  OnLineStatusCustomSmartViewCtrl$1(OnLineStatusCustomSmartViewCtrl paramOnLineStatusCustomSmartViewCtrl) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    OnLineStatusCustomSmartViewCtrl.a(this.a, paramLottieDrawable);
    OnLineStatusCustomSmartViewCtrl.b(this.a).setImageDrawable(OnLineStatusCustomSmartViewCtrl.a(this.a));
    if (OnLineStatusCustomSmartViewCtrl.c(this.a))
    {
      this.a.d();
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusCustomSmartViewCtrl.1
 * JD-Core Version:    0.7.0.1
 */