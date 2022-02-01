package com.tencent.mobileqq.kandian.glue.viola;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class CommonSuspensionGestureLayout$9
  extends AnimatorListenerAdapter
{
  CommonSuspensionGestureLayout$9(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.jdField_a_of_type_AndroidViewView.setLayerType(0, null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoanimation", 2, "alpha animation end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout.9
 * JD-Core Version:    0.7.0.1
 */