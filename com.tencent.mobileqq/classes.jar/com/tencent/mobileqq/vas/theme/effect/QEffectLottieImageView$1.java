package com.tencent.mobileqq.vas.theme.effect;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.engine.QEffectData;

class QEffectLottieImageView$1
  implements OnCompositionLoadedListener
{
  QEffectLottieImageView$1(QEffectLottieImageView paramQEffectLottieImageView) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if ((QLog.isColorLevel()) || (paramLottieComposition == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompositionLoaded: composition= ");
      localStringBuilder.append(paramLottieComposition);
      QLog.e("QEffectLottieImageView", 1, localStringBuilder.toString());
    }
    if (paramLottieComposition == null) {
      return;
    }
    if (QEffectLottieImageView.a(this.a))
    {
      paramLottieComposition = new StringBuilder();
      paramLottieComposition.append("onCompositionLoaded: mIsStop ");
      paramLottieComposition.append(QEffectLottieImageView.a(this.a));
      QLog.e("QEffectLottieImageView", 1, paramLottieComposition.toString());
      return;
    }
    this.a.cancelAnimation();
    this.a.setComposition(paramLottieComposition);
    this.a.setProgress(0.0F);
    paramLottieComposition = this.a;
    paramLottieComposition.setRepeatCount(QEffectLottieImageView.b(paramLottieComposition).repeat);
    this.a.setVisibility(0);
    this.a.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.effect.QEffectLottieImageView.1
 * JD-Core Version:    0.7.0.1
 */