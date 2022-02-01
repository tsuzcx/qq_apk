package com.tencent.mobileqq.widget.bounce;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.viewpager.widget.PagerAdapter;

public class OverScrollEffect
{
  protected float a;
  private int jdField_a_of_type_Int = 200;
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  
  public OverScrollEffect(BounceViewPager paramBounceViewPager)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = paramBounceViewPager;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager, "Pull", new float[] { this.jdField_a_of_type_Float, 0.0F });
    this.jdField_a_of_type_AndroidAnimationAnimator.setInterpolator(new DecelerateInterpolator());
    float f = Math.abs(-this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidAnimationAnimator.setDuration((this.jdField_a_of_type_Int * f));
    this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new OverScrollEffect.1(this));
    this.jdField_a_of_type_AndroidAnimationAnimator.start();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a();
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Float < 0.0F)) {
      return true;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getAdapter().getCount() - 1 == this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem()) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (this.jdField_a_of_type_Float > 0.0F);
  }
  
  protected void b()
  {
    Animator localAnimator = this.jdField_a_of_type_AndroidAnimationAnimator;
    if ((localAnimator != null) && (localAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new OverScrollEffect.2(this));
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.bounce.OverScrollEffect
 * JD-Core Version:    0.7.0.1
 */