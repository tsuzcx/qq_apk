package com.tencent.mobileqq.popanim.state;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;

class PopAnimState$2
  implements Animator.AnimatorListener
{
  PopAnimState$2(PopAnimState paramPopAnimState, float paramFloat) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    PopAnimState.a(this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState).setTranslationY(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    PopAnimState.a(this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState).setTranslationY(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    PopAnimState.a(this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState).setTranslationY(this.jdField_a_of_type_Float);
    PopOutAnimViewHelper.a(0, new View[] { PopAnimState.a(this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState), PopAnimState.a(this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState), PopAnimState.b(this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState) });
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.PopAnimState.2
 * JD-Core Version:    0.7.0.1
 */