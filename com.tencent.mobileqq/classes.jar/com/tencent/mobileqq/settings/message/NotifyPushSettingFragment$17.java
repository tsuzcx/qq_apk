package com.tencent.mobileqq.settings.message;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class NotifyPushSettingFragment$17
  implements ValueAnimator.AnimatorUpdateListener
{
  NotifyPushSettingFragment$17(NotifyPushSettingFragment paramNotifyPushSettingFragment, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = this.a.getLayoutParams();
    paramValueAnimator.height = i;
    this.a.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.17
 * JD-Core Version:    0.7.0.1
 */