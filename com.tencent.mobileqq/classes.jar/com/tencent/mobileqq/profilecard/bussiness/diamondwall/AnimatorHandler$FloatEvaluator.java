package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import android.animation.TypeEvaluator;

class AnimatorHandler$FloatEvaluator
  implements TypeEvaluator
{
  AnimatorHandler$FloatEvaluator(AnimatorHandler paramAnimatorHandler) {}
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramFloat *= 3.0F;
    if (paramFloat <= 0.45F) {
      return Float.valueOf(1.0F - paramFloat / 0.45F * 0.6F);
    }
    if (paramFloat <= 1.3F)
    {
      d = (paramFloat - 0.45F) / 0.85F * 0.6F;
      Double.isNaN(d);
      return Double.valueOf(d + 0.4D);
    }
    if (paramFloat <= 2.45F) {
      return Float.valueOf(1.0F - (paramFloat - 1.3F) / 1.15F * 0.6F);
    }
    double d = (paramFloat - 2.45F) / 0.55F * 0.6F;
    Double.isNaN(d);
    return Double.valueOf(d + 0.4D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler.FloatEvaluator
 * JD-Core Version:    0.7.0.1
 */