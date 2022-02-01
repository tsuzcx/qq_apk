package com.tencent.mobileqq.portal;

import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class ImageShakeAnimView$1
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  ImageShakeAnimView$1(ImageShakeAnimView paramImageShakeAnimView) {}
  
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    if (this.a.i)
    {
      if (paramFloat1.floatValue() < 180.0F)
      {
        this.a.d = (1.0F - paramFloat1.floatValue() * 0.01F / 180.0F);
        this.a.e = (paramFloat1.floatValue() * 0.02F / 180.0F + 1.0F);
        return;
      }
      if (paramFloat1.floatValue() < 360.0F)
      {
        paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 180.0F);
        this.a.d = (paramValueAnimation.floatValue() * 0.03F / 180.0F + 0.99F);
        this.a.e = (1.02F - paramValueAnimation.floatValue() * 0.04F / 180.0F);
        return;
      }
      if (paramFloat1.floatValue() < 540.0F)
      {
        paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 360.0F);
        this.a.d = (1.02F - paramValueAnimation.floatValue() * 0.03F / 180.0F);
        this.a.e = (paramValueAnimation.floatValue() * 0.03F / 180.0F + 0.98F);
        return;
      }
      paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 540.0F);
      this.a.d = (paramValueAnimation.floatValue() * 0.01F / 180.0F + 0.99F);
      this.a.e = (1.01F - paramValueAnimation.floatValue() * 0.01F / 180.0F);
      return;
    }
    if (paramFloat1.floatValue() < 120.0F)
    {
      this.a.d = (1.0F - paramFloat1.floatValue() * 0.02F / 120.0F);
      this.a.e = (paramFloat1.floatValue() * 0.04F / 120.0F + 1.0F);
      return;
    }
    if (paramFloat1.floatValue() < 380.0F)
    {
      paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 120.0F);
      this.a.d = (paramValueAnimation.floatValue() * 0.04F / 260.0F + 0.98F);
      this.a.e = (1.04F - paramValueAnimation.floatValue() * 0.08F / 260.0F);
      return;
    }
    paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 380.0F);
    this.a.d = (1.02F - paramValueAnimation.floatValue() * 0.02F / 120.0F);
    this.a.e = (paramValueAnimation.floatValue() * 0.04F / 120.0F + 0.96F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageShakeAnimView.1
 * JD-Core Version:    0.7.0.1
 */