package com.tencent.tfm.metrics;

import com.tencent.tfm.metrics.api.RawMeasure.Recorder;
import com.tencent.tfm.metrics.bean.LogItem;

public final class RawMeasureSDK$Recorder
  implements RawMeasure.Recorder
{
  public String[] dimensions;
  public RawMeasureSDK rawMeasure;
  public StatValue[] values;
  
  RawMeasureSDK$Recorder(RawMeasureSDK paramRawMeasureSDK)
  {
    this.rawMeasure = paramRawMeasureSDK;
  }
  
  public Recorder dimensions(String... paramVarArgs)
  {
    this.dimensions = paramVarArgs;
    return this;
  }
  
  public void record()
  {
    LogItem localLogItem = new LogItem(this.rawMeasure.name, this.dimensions, this.values, System.currentTimeMillis());
    this.rawMeasure.record(localLogItem);
  }
  
  public Recorder values(float... paramVarArgs)
  {
    if ((paramVarArgs.length > 0) && (paramVarArgs.length == this.rawMeasure.policies.length))
    {
      localObject = new StatValue[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        localObject[i] = StatValue.create(paramVarArgs[i], this.rawMeasure.policies[i]);
        i += 1;
      }
      this.values = ((StatValue[])localObject);
      return this;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("指标长度不正确");
    ((StringBuilder)localObject).append(paramVarArgs.length);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.rawMeasure.policies.length);
    paramVarArgs = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfm.metrics.RawMeasureSDK.Recorder
 * JD-Core Version:    0.7.0.1
 */