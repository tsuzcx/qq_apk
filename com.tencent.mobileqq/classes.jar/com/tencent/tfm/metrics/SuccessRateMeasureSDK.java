package com.tencent.tfm.metrics;

import com.tencent.tfm.metrics.api.RawMeasure.Recorder;
import com.tencent.tfm.metrics.api.StatPolicy;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;

public class SuccessRateMeasureSDK
  extends AbstractInstrument
  implements SuccessRateMeasure
{
  private RawMeasureSDK rawMeasureSDK;
  
  protected SuccessRateMeasureSDK(String paramString)
  {
    super(paramString);
    this.rawMeasureSDK = new RawMeasureSDK(paramString, new StatPolicy[] { StatPolicy.SUM, StatPolicy.SUM, StatPolicy.AVG });
  }
  
  public void recordFail(String... paramVarArgs)
  {
    recordFailWithAvg(0.0F, paramVarArgs);
  }
  
  public void recordFailWithAvg(float paramFloat, String... paramVarArgs)
  {
    this.rawMeasureSDK.newRecorder().dimensions(paramVarArgs).values(new float[] { 0.0F, 1.0F, paramFloat }).record();
  }
  
  public void recordSuccess(String... paramVarArgs)
  {
    recordSuccessWithAvg(0.0F, paramVarArgs);
  }
  
  public void recordSuccessWithAvg(float paramFloat, String... paramVarArgs)
  {
    this.rawMeasureSDK.newRecorder().dimensions(paramVarArgs).values(new float[] { 1.0F, 0.0F, paramFloat }).record();
  }
  
  @Deprecated
  public void traceFailWithMessage(String paramString, String... paramVarArgs)
  {
    throw new RuntimeException("未实现的接口");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.SuccessRateMeasureSDK
 * JD-Core Version:    0.7.0.1
 */