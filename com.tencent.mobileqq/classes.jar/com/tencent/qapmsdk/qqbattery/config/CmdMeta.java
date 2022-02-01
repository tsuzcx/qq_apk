package com.tencent.qapmsdk.qqbattery.config;

import com.tencent.qapmsdk.common.logger.Logger;

public class CmdMeta
  extends BaseMeta
{
  public static final String TAG = "CmdMeta";
  public int alarmMaxSendTime = 40;
  public int alarmSendTime = 30;
  public int maintainCount = 20;
  public long monitorInterval = 2000L;
  
  public CmdMeta parse(String paramString)
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
      this.monitorInterval = (Integer.valueOf(localObject[0][0]).intValue() * 1000L);
      this.alarmSendTime = Integer.valueOf(localObject[0][1]).intValue();
      this.alarmMaxSendTime = Integer.valueOf(localObject[0][2]).intValue();
      this.maintainCount = Integer.valueOf(localObject[0][3]).intValue();
      return this;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("CmdMeta", paramString);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.config.CmdMeta
 * JD-Core Version:    0.7.0.1
 */