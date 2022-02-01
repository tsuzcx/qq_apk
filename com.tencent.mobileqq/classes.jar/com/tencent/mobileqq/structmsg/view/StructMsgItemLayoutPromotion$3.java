package com.tencent.mobileqq.structmsg.view;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class StructMsgItemLayoutPromotion$3
  implements View.OnAttachStateChangeListener
{
  StructMsgItemLayoutPromotion$3(StructMsgItemLayoutPromotion paramStructMsgItemLayoutPromotion, ObjectAnimator paramObjectAnimator) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion.3
 * JD-Core Version:    0.7.0.1
 */