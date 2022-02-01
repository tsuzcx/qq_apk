package com.tencent.mobileqq.guild.channel.create.dialog;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class BaseDialogFragment$4
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseDialogFragment$4(BaseDialogFragment paramBaseDialogFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = BaseDialogFragment.e(this.a).getLayoutParams();
    paramValueAnimator.height = i;
    BaseDialogFragment.e(this.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment.4
 * JD-Core Version:    0.7.0.1
 */