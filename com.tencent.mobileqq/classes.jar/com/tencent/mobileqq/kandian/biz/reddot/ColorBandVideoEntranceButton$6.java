package com.tencent.mobileqq.kandian.biz.reddot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class ColorBandVideoEntranceButton$6
  extends AnimatorListenerAdapter
{
  ColorBandVideoEntranceButton$6(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "scaleAnimatorSet cancel");
    ColorBandVideoEntranceButton.a(this.b, this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorBandVideoEntranceButton.a(this.b, this.a);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "scaleAnimatorSet pause");
    ColorBandVideoEntranceButton.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton.6
 * JD-Core Version:    0.7.0.1
 */