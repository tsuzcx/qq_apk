package com.tencent.mobileqq.profile.like;

import android.view.animation.Interpolator;

final class PraiseAnimation$1
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.3333333F) {
      return 0.0F;
    }
    return (paramFloat - 0.3333333F) * 1.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseAnimation.1
 * JD-Core Version:    0.7.0.1
 */