package com.tencent.mobileqq.hotchat.anim;

import android.view.animation.Interpolator;

public class BezierInterpolator
  implements Interpolator
{
  public float a;
  public float b;
  
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(1.0F - paramFloat, 2.0D) * 3.0D * paramFloat * this.a + 3.0F * (1.0F - paramFloat) * Math.pow(paramFloat, 2.0D) * this.b + Math.pow(paramFloat, 3.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.BezierInterpolator
 * JD-Core Version:    0.7.0.1
 */