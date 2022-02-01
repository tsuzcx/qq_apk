package com.tencent.mobileqq.portal;

import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class ImageAlphaSwitchView$1
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  ImageAlphaSwitchView$1(ImageAlphaSwitchView paramImageAlphaSwitchView) {}
  
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.jdField_a_of_type_Float = paramFloat1.floatValue();
    if (paramFloat1.floatValue() >= 255.0F)
    {
      paramValueAnimation = this.a;
      paramValueAnimation.jdField_a_of_type_AndroidGraphicsBitmap = paramValueAnimation.b;
      paramValueAnimation = this.a;
      paramValueAnimation.b = null;
      paramValueAnimation.jdField_a_of_type_Float = 0.0F;
      if (paramValueAnimation.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation.cancel();
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageAlphaSwitchView.1
 * JD-Core Version:    0.7.0.1
 */