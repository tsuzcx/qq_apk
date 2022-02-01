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
    if (paramLong2 - paramLong1 > 0L)
    {
      long l2 = this.mRandom.nextLong() % (paramLong2 - paramLong1) + paramLong1;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = l2 + (paramLong2 - paramLong1);
      }
      return l1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.RandomGenerator
 * JD-Core Version:    0.7.0.1
 */