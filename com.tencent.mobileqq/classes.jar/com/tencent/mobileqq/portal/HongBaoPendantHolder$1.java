package com.tencent.mobileqq.portal;

import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class HongBaoPendantHolder$1
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  HongBaoPendantHolder$1(HongBaoPendantHolder paramHongBaoPendantHolder) {}
  
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.b = paramFloat1.floatValue();
    this.a.jdField_a_of_type_Float = (1.07F - (paramFloat1.floatValue() - 1.0F));
    if (this.a.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.b = paramFloat1.floatValue();
      this.a.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.jdField_a_of_type_Float = this.a.jdField_a_of_type_Float;
    }
    this.a.a((int)(this.a.jdField_a_of_type_Int * paramFloat1.floatValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongBaoPendantHolder.1
 * JD-Core Version:    0.7.0.1
 */