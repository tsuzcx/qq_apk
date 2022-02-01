package com.tencent.qapmsdk.battery.config;

import com.tencent.qapmsdk.common.logger.Logger;

public class WakeLockMeta
  extends BaseMeta
{
  public static final String TAG = "QAPM.WakeLockMeta";
  public long longTime = 7200000L;
  public long maxAcquireTime = 30000L;
  public int maxCallTimeInLongTime = 10;
  public int maxCallTimeInShortTime = 3;
  public long shortTime = 600000L;
  
  public WakeLockMeta parse(String paramString)
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
      if ((localObject.length >= 1) && (localObject[0].length >= 1))
      {
        this.maxAcquireTime = (Integer.valueOf(localObject[0][0]).intValue() * 1000L);
        this.maxAcquireTime *= 10L;
      }
      if ((localObject.length >= 2) && (localObject[1].length >= 2))
      {
        this.maxCallTimeInShortTime = Integer.valueOf(localObject[1][0]).intValue();
        this.shortTime = (Integer.valueOf(localObject[1][1]).intValue() * 60 * 1000L);
      }
      if ((localObject.length >= 3) && (localObject[2].length >= 2))
      {
        this.maxCallTimeInLongTime = Integer.valueOf(localObject[2][0]).intValue();
        this.longTime = (Integer.valueOf(localObject[2][1]).intValue() * 60 * 1000L);
      }
      return this;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM.WakeLockMeta", paramString);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.config.WakeLockMeta
 * JD-Core Version:    0.7.0.1
 */