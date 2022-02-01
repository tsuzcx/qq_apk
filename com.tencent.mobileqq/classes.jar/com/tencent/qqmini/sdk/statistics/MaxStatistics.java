package com.tencent.qqmini.sdk.statistics;

public class MaxStatistics
  implements Statistic
{
  private float mMax = 1.4E-45F;
  
  public void addSample(float paramFloat)
  {
    if (paramFloat > this.mMax) {
      this.mMax = paramFloat;
    }
  }
  
  public float calculate()
  {
    return this.mMax;
  }
  
  public void reset()
  {
    this.mMax = 1.4E-45F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.statistics.MaxStatistics
 * JD-Core Version:    0.7.0.1
 */