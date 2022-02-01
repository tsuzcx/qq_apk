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
    this.a.c = paramFloat1.floatValue();
    if (paramFloat1.floatValue() >= 255.0F)
    {
      paramValueAnimation = this.a;
      paramValueAnimation.f = paramValueAnimation.g;
      paramValueAnimation = this.a;
      paramValueAnimation.g = null;
      paramValueAnimation.c = 0.0F;
      if (paramValueAnimation.b != null)
      {
        this.a.b.cancel();
        this.a.b = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageAlphaSwitchView.1
 * JD-Core Version:    0.7.0.1
 */