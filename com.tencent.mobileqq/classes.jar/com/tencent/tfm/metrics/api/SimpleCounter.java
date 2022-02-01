package com.tencent.tfm.metrics.api;

public abstract interface SimpleCounter
  extends Measure
{
  public abstract void count(float paramFloat, String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfm.metrics.api.SimpleCounter
 * JD-Core Version:    0.7.0.1
 */