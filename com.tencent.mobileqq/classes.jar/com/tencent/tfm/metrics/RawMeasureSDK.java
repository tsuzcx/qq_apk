package com.tencent.tfm.metrics;

import com.tencent.tfm.metrics.api.RawMeasure;
import com.tencent.tfm.metrics.api.RawMeasure.Recorder;
import com.tencent.tfm.metrics.api.StatPolicy;

public class RawMeasureSDK
  extends AbstractInstrument
  implements RawMeasure
{
  public final StatPolicy[] policies;
  
  RawMeasureSDK(String paramString, StatPolicy... paramVarArgs)
  {
    super(paramString);
    this.policies = paramVarArgs;
    if (paramVarArgs.length <= 0) {
      throw new IllegalArgumentException("no policy for RawMeasure");
    }
  }
  
  public RawMeasure.Recorder newRecorder()
  {
    return new RawMeasureSDK.Recorder(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.RawMeasureSDK
 * JD-Core Version:    0.7.0.1
 */