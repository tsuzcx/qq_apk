package com.tencent.mobileqq.flashshow.widgets.comment;

import android.view.animation.Interpolator;

class FSSlidBottomView$1
  implements Interpolator
{
  FSSlidBottomView$1(FSSlidBottomView paramFSSlidBottomView) {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSSlidBottomView.1
 * JD-Core Version:    0.7.0.1
 */