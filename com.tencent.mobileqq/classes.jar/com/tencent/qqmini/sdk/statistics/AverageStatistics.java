package com.tencent.qqmini.sdk.statistics;

public class AverageStatistics
  implements Statistic
{
  private int mCount;
  private float mTotal;
  
  public void addSample(float paramFloat)
  {
    this.mTotal += paramFloat;
    this.mCount += 1;
  }
  
  public float calculate()
  {
    if (this.mCount == 0) {
      return 0.0F;
    }
    return this.mTotal / this.mCount;
  }
  
  public void reset()
  {
    this.mCount = 0;
    this.mTotal = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.statistics.AverageStatistics
 * JD-Core Version:    0.7.0.1
 */