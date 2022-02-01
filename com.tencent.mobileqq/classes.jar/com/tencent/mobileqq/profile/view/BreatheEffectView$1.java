package com.tencent.mobileqq.profile.view;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class BreatheEffectView$1
  implements TypeEvaluator<Rect>
{
  BreatheEffectView$1(BreatheEffectView paramBreatheEffectView) {}
  
  public Rect a(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    return new Rect(paramRect1.left + (int)((paramRect2.left - paramRect1.left) * paramFloat), paramRect1.top + (int)((paramRect2.top - paramRect1.top) * paramFloat), paramRect1.right + (int)((paramRect2.right - paramRect1.right) * paramFloat), paramRect1.bottom + (int)((paramRect2.bottom - paramRect1.bottom) * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.BreatheEffectView.1
 * JD-Core Version:    0.7.0.1
 */