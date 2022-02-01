package com.tencent.mobileqq.facetoface;

import android.view.animation.Interpolator;

class Face2FaceAddFriendAnim$EaseInOutElasticInterpolator
  implements Interpolator
{
  Face2FaceAddFriendAnim$EaseInOutElasticInterpolator(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim) {}
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    paramFloat *= 2.0F;
    if (paramFloat >= 2.0F) {
      return 1.0F;
    }
    if (paramFloat < 1.0F)
    {
      paramFloat -= 1.0F;
      d1 = Math.pow(2.0D, 10.0F * paramFloat);
      d2 = paramFloat - 0.1125F;
      Double.isNaN(d2);
      d3 = 0.45F;
      Double.isNaN(d3);
      return (float)(d1 * -0.5D * Math.sin(d2 * 6.283185307179586D / d3));
    }
    paramFloat -= 1.0F;
    double d1 = Math.pow(2.0D, -10.0F * paramFloat);
    double d2 = paramFloat - 0.1125F;
    Double.isNaN(d2);
    double d3 = 0.45F;
    Double.isNaN(d3);
    return (float)(d1 * 0.5D * Math.sin(d2 * 6.283185307179586D / d3)) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim.EaseInOutElasticInterpolator
 * JD-Core Version:    0.7.0.1
 */