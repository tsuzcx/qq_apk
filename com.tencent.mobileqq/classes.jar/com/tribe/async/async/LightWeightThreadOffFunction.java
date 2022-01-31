package com.tribe.async.async;

import com.tribe.async.reactive.StreamFunction;

public class LightWeightThreadOffFunction<IN>
  extends StreamFunction<IN, IN>
{
  protected void call(IN paramIN)
  {
    paramIN = new ThreadOffRunnable(paramIN);
    Bosses.get().postLightWeightJob(paramIN, 0);
  }
  
  protected void error(Error paramError)
  {
    paramError = new ThreadOffErrRunnable(paramError);
    Bosses.get().postLightWeightJob(paramError, 0);
  }
  
  protected void onCancel() {}
  
  private class ThreadOffErrRunnable
    implements Runnable
  {
    private Error mError;
    
    public ThreadOffErrRunnable(Error paramError)
    {
      this.mError = paramError;
    }
    
    public void run()
    {
      LightWeightThreadOffFunction.this.notifyError(this.mError);
    }
  }
  
  private class ThreadOffRunnable
    implements Runnable
  {
    private IN mResult;
    
    public ThreadOffRunnable()
    {
      Object localObject;
      this.mResult = localObject;
    }
    
    public void run()
    {
      LightWeightThreadOffFunction.this.notifyResult(this.mResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.LightWeightThreadOffFunction
 * JD-Core Version:    0.7.0.1
 */