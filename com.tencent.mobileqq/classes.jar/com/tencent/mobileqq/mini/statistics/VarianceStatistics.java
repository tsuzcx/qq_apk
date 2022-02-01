package com.tencent.mobileqq.mini.statistics;

public class VarianceStatistics
  implements Statistic
{
  private int mIndex = 0;
  private final float[] mSamples;
  
  public VarianceStatistics(int paramInt)
  {
    this.mSamples = new float[paramInt];
  }
  
  public void addSample(float paramFloat)
  {
    float[] arrayOfFloat = this.mSamples;
    int i = this.mIndex;
    arrayOfFloat[(i % arrayOfFloat.length)] = paramFloat;
    this.mIndex = (i + 1);
  }
  
  public float calculate()
  {
    int i = this.mIndex;
    float[] arrayOfFloat = this.mSamples;
    if (i >= arrayOfFloat.length) {
      i = arrayOfFloat.length;
    }
    float f2 = 0.0F;
    if (i == 0) {
      return 0.0F;
    }
    int k = 0;
    int j = 0;
    float f1 = 0.0F;
    while (j < i)
    {
      f1 += this.mSamples[j];
      j += 1;
    }
    float f3 = i;
    float f4 = f1 / f3;
    j = k;
    f1 = f2;
    while (j < i)
    {
      f2 = this.mSamples[j] - f4;
      f1 += f2 * f2;
      j += 1;
    }
    return f1 / f3;
  }
  
  public void reset()
  {
    this.mIndex = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.statistics.VarianceStatistics
 * JD-Core Version:    0.7.0.1
 */