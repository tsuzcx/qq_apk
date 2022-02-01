package com.tencent.mobileqq.hotchat.anim;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.concurrent.atomic.AtomicInteger;

class HeartAnimator$1
  implements Animation.AnimationListener
{
  HeartAnimator$1(HeartAnimator paramHeartAnimator, ViewGroup paramViewGroup, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.jdField_a_of_type_AndroidOsHandler.post(new HeartAnimator.1.1(this));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    if (HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator) != null) {
      HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator).b(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator) != null) {
      HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator).a(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartAnimator.1
 * JD-Core Version:    0.7.0.1
 */