package com.tencent.tfm.metrics.api;

import android.content.Context;

public abstract interface Metrics
{
  public abstract RawMeasure buildRawMeasure(String paramString, StatPolicy... paramVarArgs);
  
  public abstract SimpleCounter buildSimpleCounter(String paramString);
  
  public abstract SuccessRateMeasure buildSuccessRateCounter(String paramString);
  
  public abstract <I extends Measure> I get(String paramString, Class<I> paramClass);
  
  public abstract void start(Context paramContext, MetricsConfig paramMetricsConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfm.metrics.api.Metrics
 * JD-Core Version:    0.7.0.1
 */