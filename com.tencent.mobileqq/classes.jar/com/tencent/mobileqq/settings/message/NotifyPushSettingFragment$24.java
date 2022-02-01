package com.tencent.mobileqq.settings.message;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.widget.Switch;

class NotifyPushSettingFragment$24
  extends AnimatorListenerAdapter
{
  NotifyPushSettingFragment$24(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    NotifyPushSettingFragment.e(this.a).getSwitch().setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.24
 * JD-Core Version:    0.7.0.1
 */