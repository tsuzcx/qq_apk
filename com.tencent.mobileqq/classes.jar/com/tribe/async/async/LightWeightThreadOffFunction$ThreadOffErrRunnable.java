package com.tribe.async.async;

class LightWeightThreadOffFunction$ThreadOffErrRunnable
  implements Runnable
{
  private Error mError;
  
  public LightWeightThreadOffFunction$ThreadOffErrRunnable(LightWeightThreadOffFunction paramLightWeightThreadOffFunction, Error paramError)
  {
    this.mError = paramError;
  }
  
  public void run()
  {
    LightWeightThreadOffFunction.access$100(this.this$0, this.mError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.LightWeightThreadOffFunction.ThreadOffErrRunnable
 * JD-Core Version:    0.7.0.1
 */