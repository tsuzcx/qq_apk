package com.tencent.qqperf.abfactor;

import com.tencent.qapmsdk.base.reporter.ab.AbType;

public class AbFactorAIODynamicBg
  extends AbType
{
  public void active()
  {
    setPerfTimeout(1, 9223372036854775807L);
    setPerfTimeout(4, 9223372036854775807L);
    setPerfTimeout(2, 9223372036854775807L);
  }
  
  public String getDescription()
  {
    return "AIO3D背景";
  }
  
  public void unActive()
  {
    setPerfTimeout(1, 3000L);
    setPerfTimeout(2, 2000L);
    setPerfTimeout(4, 9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.abfactor.AbFactorAIODynamicBg
 * JD-Core Version:    0.7.0.1
 */