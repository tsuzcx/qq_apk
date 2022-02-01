package com.tencent.timi.game.web.business.impl.common;

import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class TimiBrowserActivity$3
  extends D8SafeAnimatorListener
{
  TimiBrowserActivity$3(TimiBrowserActivity paramTimiBrowserActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    TimiBrowserActivity.a(this.a).setTranslationY(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TimiBrowserActivity.a(this.a).setTranslationY(0.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    TimiBrowserActivity.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.common.TimiBrowserActivity.3
 * JD-Core Version:    0.7.0.1
 */