package com.tencent.taveffect.utils;

import java.util.Random;

public class RandomUtils
{
  public static float randomFloat(float paramFloat1, float paramFloat2)
  {
    return new Random().nextFloat() * paramFloat2 * 1000.0F % ((paramFloat2 - paramFloat1) * 1000.0F + 1.0F) / 1000.0F + paramFloat1;
  }
  
  public static int randomInt(int paramInt1, int paramInt2)
  {
    return new Random().nextInt(paramInt2) % (paramInt2 - paramInt1 + 1) + paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.taveffect.utils.RandomUtils
 * JD-Core Version:    0.7.0.1
 */