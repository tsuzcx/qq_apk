package com.tencent.mobileqq.settings.message;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;

class NotifyPushSettingFragment$16$1
  extends AnimatorListenerAdapter
{
  NotifyPushSettingFragment$16$1(NotifyPushSettingFragment.16 param16) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    NotifyPushSettingFragment.s(this.a.a).getSwitch().setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.16.1
 * JD-Core Version:    0.7.0.1
 */