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
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.b;
      this.a.b = null;
      this.a.jdField_a_of_type_Float = 0.0F;
      if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation.cancel();
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageAlphaSwitchView.1
 * JD-Core Version:    0.7.0.1
 */