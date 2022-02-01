package com.tencent.mobileqq.writetogetherui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class UserStateBar$2
  extends AnimatorListenerAdapter
{
  UserStateBar$2(UserStateBar paramUserStateBar) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    UserStateBar.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.UserStateBar.2
 * JD-Core Version:    0.7.0.1
 */