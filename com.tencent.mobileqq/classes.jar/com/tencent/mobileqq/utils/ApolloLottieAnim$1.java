package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

class ApolloLottieAnim$1
  implements OnCompositionLoadedListener
{
  ApolloLottieAnim$1(ApolloLottieAnim paramApolloLottieAnim, DiniFlyAnimationView paramDiniFlyAnimationView, boolean paramBoolean) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "composition is null ,return");
      }
      return;
    }
    if (ApolloLottieAnim.a(this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "anim is destroy ,return");
      }
      return;
    }
    this.a.setComposition(paramLottieComposition);
    this.a.setImageAssetDelegate(new ApolloLottieAnim.1.1(this));
    if (this.b)
    {
      this.a.setVisibility(0);
      this.a.playAnimation();
    }
    ApolloLottieAnim.a(this.c, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ApolloLottieAnim.1
 * JD-Core Version:    0.7.0.1
 */