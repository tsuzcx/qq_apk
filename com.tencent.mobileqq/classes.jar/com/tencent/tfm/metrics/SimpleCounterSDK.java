package com.tencent.tfm.metrics;

import com.tencent.tfm.metrics.api.RawMeasure.Recorder;
import com.tencent.tfm.metrics.api.SimpleCounter;
import com.tencent.tfm.metrics.api.StatPolicy;

public class SimpleCounterSDK
  extends AbstractInstrument
  implements SimpleCounter
{
  private RawMeasureSDK rawMeasureSDK;
  
  SimpleCounterSDK(String paramString)
  {
    super(paramString);
    this.rawMeasureSDK = new RawMeasureSDK(paramString, new StatPolicy[] { StatPolicy.SUM });
  }
  
  public void count(float paramFloat, String... paramVarArgs)
  {
    this.rawMeasureSDK.newRecorder().dimensions(paramVarArgs).values(new float[] { paramFloat }).record();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.SimpleCounterSDK
 * JD-Core Version:    0.7.0.1
 */