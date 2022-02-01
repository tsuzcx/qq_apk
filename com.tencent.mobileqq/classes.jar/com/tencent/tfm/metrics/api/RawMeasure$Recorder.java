package com.tencent.tfm.metrics.api;

public abstract interface RawMeasure$Recorder
{
  public abstract Recorder dimensions(String... paramVarArgs);
  
  public abstract void record();
  
  public abstract Recorder values(float... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.api.RawMeasure.Recorder
 * JD-Core Version:    0.7.0.1
 */