package me.ele.uetool;

import android.animation.TimeInterpolator;

class UETMenu$ReverseInterpolator
  implements TimeInterpolator
{
  private TimeInterpolator mWrappedInterpolator;
  
  UETMenu$ReverseInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    this.mWrappedInterpolator = paramTimeInterpolator;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return this.mWrappedInterpolator.getInterpolation(Math.abs(paramFloat - 1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETMenu.ReverseInterpolator
 * JD-Core Version:    0.7.0.1
 */