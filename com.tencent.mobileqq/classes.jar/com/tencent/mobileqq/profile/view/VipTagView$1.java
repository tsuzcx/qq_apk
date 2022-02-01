package com.tencent.mobileqq.profile.view;

import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class VipTagView$1
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  VipTagView$1(VipTagView paramVipTagView) {}
  
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    VipTagView.a(this.a, paramFloat1.floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipTagView.1
 * JD-Core Version:    0.7.0.1
 */