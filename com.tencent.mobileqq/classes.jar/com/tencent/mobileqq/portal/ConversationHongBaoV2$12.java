package com.tencent.mobileqq.portal;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class ConversationHongBaoV2$12
  implements ValueAnimator.AnimatorUpdateListener
{
  ConversationHongBaoV2$12(ConversationHongBaoV2 paramConversationHongBaoV2, RelativeLayout.LayoutParams paramLayoutParams, View paramView1, View paramView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    int i = (int)(-ConversationHongBaoV2.e(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2) * f);
    paramValueAnimator = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    paramValueAnimator.topMargin = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramValueAnimator);
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.e) {
      this.b.setAlpha(1.0F - f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.12
 * JD-Core Version:    0.7.0.1
 */