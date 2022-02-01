package com.tencent.mobileqq.shortvideo.mtveffects;

import java.util.Random;

public class RandomGenerator
{
  private Random mRandom = new Random();
  private long mSeed = 0L;
  
  public RandomGenerator(long paramLong)
  {
    this.mRandom.setSeed(paramLong);
    this.mSeed = paramLong;
  }
  
  public long nextLong()
  {
    return this.mRandom.nextLong();
  }
  
  public long nextLong(long paramLong1, long paramLong2)
  {
    long l = paramLong2 - paramLong1;
    if (l > 0L)
    {
      paramLong2 = this.mRandom.nextLong() % l + paramLong1;
      paramLong1 = paramLong2;
      if (paramLong2 < 0L) {
        paramLong1 = paramLong2 + l;
      }
      return paramLong1;
    }
    return 0L;
  }
  
  public void reset()
  {
    this.mRandom.setSeed(this.mSeed);
  }
  
  public void setSeed(long paramLong)
  {
    this.mSeed = paramLong;
    this.mRandom.setSeed(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.RandomGenerator
 * JD-Core Version:    0.7.0.1
 */