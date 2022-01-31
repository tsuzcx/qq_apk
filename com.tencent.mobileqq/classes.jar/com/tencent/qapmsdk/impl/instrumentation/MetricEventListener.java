package com.tencent.qapmsdk.impl.instrumentation;

public abstract interface MetricEventListener
{
  public abstract void asyncEnterMethod(QAPMTraceUnit paramQAPMTraceUnit);
  
  public abstract void enterMethod(QAPMTraceUnit paramQAPMTraceUnit);
  
  public abstract void exitMethod();
  
  public abstract void exitMethodCustom(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.MetricEventListener
 * JD-Core Version:    0.7.0.1
 */