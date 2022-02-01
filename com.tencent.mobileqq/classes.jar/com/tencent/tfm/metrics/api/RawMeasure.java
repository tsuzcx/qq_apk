package com.tencent.tfm.metrics.api;

public abstract interface RawMeasure
  extends Measure
{
  public abstract RawMeasure.Recorder newRecorder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.api.RawMeasure
 * JD-Core Version:    0.7.0.1
 */