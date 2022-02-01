package com.tencent.mobileqq.portal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Handler;
import android.widget.ImageView;

class ConversationHongBaoV2$9
  implements Animator.AnimatorListener
{
  ConversationHongBaoV2$9(ConversationHongBaoV2 paramConversationHongBaoV2) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 200L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.9
 * JD-Core Version:    0.7.0.1
 */