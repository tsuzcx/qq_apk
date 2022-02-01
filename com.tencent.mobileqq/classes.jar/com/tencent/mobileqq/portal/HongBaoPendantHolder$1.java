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
    this.a.D = paramFloat1.floatValue();
    this.a.C = (1.07F - (paramFloat1.floatValue() - 1.0F));
    if (this.a.l != null)
    {
      this.a.l.j = paramFloat1.floatValue();
      this.a.l.i = this.a.C;
    }
    paramValueAnimation = this.a;
    paramValueAnimation.c((int)(paramValueAnimation.h * paramFloat1.floatValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongBaoPendantHolder.1
 * JD-Core Version:    0.7.0.1
 */