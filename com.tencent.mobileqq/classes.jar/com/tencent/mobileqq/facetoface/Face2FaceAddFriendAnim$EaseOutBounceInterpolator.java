package com.tencent.mobileqq.facetoface;

import android.view.animation.Interpolator;

class Face2FaceAddFriendAnim$EaseOutBounceInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.3636364F) {
      return 7.5625F * paramFloat * paramFloat;
    }
    if (paramFloat < 0.7272728F)
    {
      paramFloat -= 0.5454546F;
      return paramFloat * (7.5625F * paramFloat) + 0.75F;
    }
    if (paramFloat < 0.9090909F)
    {
      paramFloat -= 0.8181818F;
      return paramFloat * (7.5625F * paramFloat) + 0.9375F;
    }
    paramFloat -= 0.9545454F;
    return paramFloat * (7.5625F * paramFloat) + 0.984375F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim.EaseOutBounceInterpolator
 * JD-Core Version:    0.7.0.1
 */