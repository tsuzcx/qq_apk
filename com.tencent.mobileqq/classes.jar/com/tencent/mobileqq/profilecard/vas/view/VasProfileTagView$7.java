package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

class VasProfileTagView$7
  implements TypeEvaluator<PointF>
{
  VasProfileTagView$7(VasProfileTagView paramVasProfileTagView) {}
  
  public PointF evaluate(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF1.y;
    return new PointF(f1 + (paramPointF2.x - f1) * paramFloat, f2 + paramFloat * (paramPointF2.y - f2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.7
 * JD-Core Version:    0.7.0.1
 */