package com.tencent.mobileqq.mini.statistics;

public abstract interface Statistic
{
  public abstract void addSample(float paramFloat);
  
  public abstract float calculate();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.statistics.Statistic
 * JD-Core Version:    0.7.0.1
 */