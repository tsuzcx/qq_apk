package com.tencent.mobileqq.dinifly.utils;

public class MeanCalculator
{
  private int n;
  private float sum;
  
  public void add(float paramFloat)
  {
    this.sum += paramFloat;
    this.n += 1;
    int i = this.n;
    if (i == 2147483647)
    {
      this.sum /= 2.0F;
      this.n = (i / 2);
    }
  }
  
  public float getMean()
  {
    int i = this.n;
    if (i == 0) {
      return 0.0F;
    }
    return this.sum / i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.MeanCalculator
 * JD-Core Version:    0.7.0.1
 */