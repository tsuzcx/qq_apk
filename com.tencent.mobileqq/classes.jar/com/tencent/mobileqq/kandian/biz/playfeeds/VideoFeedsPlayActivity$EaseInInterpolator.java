package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.animation.Interpolator;

public class VideoFeedsPlayActivity$EaseInInterpolator
  implements Interpolator
{
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = -paramFloat3;
    double d = paramFloat1 / paramFloat4;
    Double.isNaN(d);
    return f * (float)Math.cos(d * 1.570796326794897D) + paramFloat3 + paramFloat2;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return a(paramFloat, 0.0F, 1.0F, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity.EaseInInterpolator
 * JD-Core Version:    0.7.0.1
 */