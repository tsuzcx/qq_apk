package com.tencent.mobileqq.portal;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class ConversationHongBaoV2$11
  implements Animator.AnimatorListener
{
  ConversationHongBaoV2$11(ConversationHongBaoV2 paramConversationHongBaoV2, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "doShowTitleAnim onAnimationCancel");
    }
    this.b.t();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "doShowTitleAnim onAnimationEnd");
    }
    this.b.t();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.b.n) {
      this.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.11
 * JD-Core Version:    0.7.0.1
 */