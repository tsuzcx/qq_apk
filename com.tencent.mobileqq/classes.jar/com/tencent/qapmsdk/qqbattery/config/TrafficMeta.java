package com.tencent.qapmsdk.qqbattery.config;

import com.tencent.qapmsdk.common.logger.Logger;

public class TrafficMeta
  extends BaseMeta
{
  public static final String TAG = "TrafficMeta";
  public long bgCollectCount = 1L;
  private boolean dumpOtherProcCycling = true;
  public long firstBgInterval = 300000L;
  public long firstFgInterval = 300000L;
  public long secondFgInterval = 1800000L;
  public long thirdFgInterval = 3600000L;
  
  public TrafficMeta parse(String paramString)
  {
    try
    {
      Object localObject = (String[][])null;
      paramString = paramString.split(";");
      localObject = new String[paramString.length][];
      int i = 0;
      while (i < paramString.length)
      {
        localObject[i] = paramString[i].split(",");
        i += 1;
      }
      if ((localObject.length >= 1) && (localObject[0].length >= 3))
      {
        this.firstFgInterval = (Integer.valueOf(localObject[0][0]).intValue() * 60 * 1000L);
        this.secondFgInterval = (Integer.valueOf(localObject[0][1]).intValue() * 60 * 1000L);
        this.thirdFgInterval = (Integer.valueOf(localObject[0][2]).intValue() * 60 * 1000L);
      }
      if ((localObject.length >= 2) && (localObject[1].length >= 2))
      {
        this.firstBgInterval = (Integer.valueOf(localObject[1][0]).intValue() * 60 * 1000L);
        this.dumpOtherProcCycling = localObject[1][1].equals("1");
      }
      if ((localObject.length >= 3) && (localObject[2].length >= 1))
      {
        this.firstBgInterval = (Integer.valueOf(localObject[2][0]).intValue() * 60 * 1000L);
        this.bgCollectCount = Integer.valueOf(localObject[2][1]).intValue();
        return this;
      }
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("TrafficMeta", paramString);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.config.TrafficMeta
 * JD-Core Version:    0.7.0.1
 */