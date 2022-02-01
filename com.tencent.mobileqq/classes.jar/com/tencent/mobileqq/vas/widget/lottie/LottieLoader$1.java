package com.tencent.mobileqq.vas.widget.lottie;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

class LottieLoader$1
  implements OnCompositionLoadedListener
{
  LottieLoader$1(LottieLoader paramLottieLoader, DiniFlyAnimationView paramDiniFlyAnimationView, boolean paramBoolean) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieLoader", 2, "composition is null ,return");
      }
      return;
    }
    if (LottieLoader.access$000(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LottieLoader", 2, "anim is destroy ,return");
      }
      return;
    }
    this.val$animationView.setComposition(paramLottieComposition);
    this.val$animationView.setImageAssetDelegate(new LottieLoader.1.1(this));
    if (this.val$autoPlay)
    {
      this.val$animationView.setVisibility(0);
      this.val$animationView.playAnimation();
    }
    LottieLoader.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.widget.lottie.LottieLoader.1
 * JD-Core Version:    0.7.0.1
 */