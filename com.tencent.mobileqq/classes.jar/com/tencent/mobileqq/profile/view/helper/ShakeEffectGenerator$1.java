package com.tencent.mobileqq.profile.view.helper;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class ShakeEffectGenerator$1
  implements Animation.AnimationListener
{
  ShakeEffectGenerator$1(ShakeEffectGenerator paramShakeEffectGenerator) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!ShakeEffectGenerator.a(this.a))
    {
      int j;
      int i;
      do
      {
        double d1 = ShakeEffectGenerator.a(this.a);
        double d2 = Math.random();
        Double.isNaN(d1);
        j = (int)(d1 * (d2 * 2.0D - 1.0D));
        i = (int)Math.sqrt(ShakeEffectGenerator.a(this.a) * ShakeEffectGenerator.a(this.a) - j * j);
        if (Math.random() <= 0.5D) {
          i = -i;
        }
      } while ((ShakeEffectGenerator.b(this.a) + j) * (ShakeEffectGenerator.b(this.a) + j) + (ShakeEffectGenerator.c(this.a) + i) * (ShakeEffectGenerator.c(this.a) + i) > ShakeEffectGenerator.d(this.a) * ShakeEffectGenerator.d(this.a));
      paramAnimation = this.a;
      ShakeEffectGenerator.a(paramAnimation, new TranslateAnimation(ShakeEffectGenerator.b(paramAnimation), ShakeEffectGenerator.b(this.a) + j, ShakeEffectGenerator.c(this.a), ShakeEffectGenerator.c(this.a) + i));
      paramAnimation = this.a;
      ShakeEffectGenerator.a(paramAnimation, ShakeEffectGenerator.b(paramAnimation) + j);
      paramAnimation = this.a;
      ShakeEffectGenerator.b(paramAnimation, ShakeEffectGenerator.c(paramAnimation) + i);
      ShakeEffectGenerator.a(this.a).setAnimationListener(ShakeEffectGenerator.a(this.a));
      ShakeEffectGenerator.a(this.a).setDuration(ShakeEffectGenerator.a(this.a) * (int)(Math.random() * 30.0D + 50.0D));
      ShakeEffectGenerator.a(this.a).startAnimation(ShakeEffectGenerator.a(this.a));
      return;
    }
    ShakeEffectGenerator.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.helper.ShakeEffectGenerator.1
 * JD-Core Version:    0.7.0.1
 */