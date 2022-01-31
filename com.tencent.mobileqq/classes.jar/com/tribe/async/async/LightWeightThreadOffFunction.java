package com.tribe.async.async;

import com.tribe.async.reactive.StreamFunction;

public class LightWeightThreadOffFunction<IN>
  extends StreamFunction<IN, IN>
{
  public void call(IN paramIN)
  {
    paramIN = new LightWeightThreadOffFunction.ThreadOffRunnable(this, paramIN);
    Bosses.get().postLightWeightJob(paramIN, 0);
  }
  
  public void error(Error paramError)
  {
    paramError = new LightWeightThreadOffFunction.ThreadOffErrRunnable(this, paramError);
    Bosses.get().postLightWeightJob(paramError, 0);
  }
  
  public void onCancel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.async.LightWeightThreadOffFunction
 * JD-Core Version:    0.7.0.1
 */