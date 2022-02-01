package com.tencent.mobileqq.guild.live.fragment.base.module.topbar;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class QQGuildLiveBaseTopBarFragment$3
  implements Animator.AnimatorListener
{
  QQGuildLiveBaseTopBarFragment$3(QQGuildLiveBaseTopBarFragment paramQQGuildLiveBaseTopBarFragment, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!QQGuildLiveBaseTopBarFragment.a(this.b)) {
      this.a.setVisibility(4);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!QQGuildLiveBaseTopBarFragment.a(this.b)) {
      this.a.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment.3
 * JD-Core Version:    0.7.0.1
 */