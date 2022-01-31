package com.tencent.mobileqq.mini.statistics;

public class VarianceStatistics
  implements Statistic
{
  private int mIndex;
  private final float[] mSamples;
  
  public VarianceStatistics(int paramInt)
  {
    this.mSamples = new float[paramInt];
  }
  
  public void addSample(float paramFloat)
  {
    this.mSamples[(this.mIndex % this.mSamples.length)] = paramFloat;
    this.mIndex += 1;
  }
  
  public float calculate()
  {
    if (this.mIndex < this.mSamples.length) {}
    for (int i = this.mIndex; i == 0; i = this.mSamples.length) {
      return 0.0F;
    }
    int j = 0;
    float f1 = 0.0F;
    while (j < i)
    {
      f1 += this.mSamples[j];
      j += 1;
    }
    float f2 = f1 / i;
    f1 = 0.0F;
    j = 0;
    while (j < i)
    {
      float f3 = this.mSamples[j] - f2;
      f1 += f3 * f3;
      j += 1;
    }
    return f1 / i;
  }
  
  public void reset()
  {
    this.mIndex = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.statistics.VarianceStatistics
 * JD-Core Version:    0.7.0.1
 */