package com.tencent.mobileqq.portal;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class ConversationHongBaoV2$13
  implements Animator.AnimatorListener
{
  ConversationHongBaoV2$13(ConversationHongBaoV2 paramConversationHongBaoV2, View paramView1, View paramView2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "doHideTitleAnim onAnimationCancel");
    }
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-ConversationHongBaoV2.e(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2));
    this.b.setLayoutParams(paramAnimator);
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.e)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "doHideTitleAnim onAnimationEnd");
    }
    paramAnimator = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramAnimator.topMargin = (-ConversationHongBaoV2.e(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2));
    this.b.setLayoutParams(paramAnimator);
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.e)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.e) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.13
 * JD-Core Version:    0.7.0.1
 */