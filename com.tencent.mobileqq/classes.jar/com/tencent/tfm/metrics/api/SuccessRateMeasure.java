package com.tencent.tfm.metrics.api;

public abstract interface SuccessRateMeasure
  extends Measure
{
  public abstract void recordFail(String... paramVarArgs);
  
  public abstract void recordFailWithAvg(float paramFloat, String... paramVarArgs);
  
  public abstract void recordSuccess(String... paramVarArgs);
  
  public abstract void recordSuccessWithAvg(float paramFloat, String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.api.SuccessRateMeasure
 * JD-Core Version:    0.7.0.1
 */