package com.tencent.tfm.metrics;

import com.tencent.tfm.metrics.api.RawMeasure.Recorder;
import com.tencent.tfm.metrics.api.StatPolicy;

public class AverageMeasure
  extends RawMeasureSDK
{
  AverageMeasure(String paramString)
  {
    super(paramString, new StatPolicy[] { StatPolicy.AVG });
  }
  
  public void avg(float paramFloat, String... paramVarArgs)
  {
    newRecorder().dimensions(paramVarArgs).values(new float[] { paramFloat }).record();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfm.metrics.AverageMeasure
 * JD-Core Version:    0.7.0.1
 */