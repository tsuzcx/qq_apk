package com.tencent.qapmsdk.qqbattery.config;

public class LogMeta
  extends BaseMeta
{
  public int alarmBigWriteTime = 100;
  public int alarmTime = 50;
  public int maintainCount = 20;
  public long monitorInterval = 2000L;
  
  public LogMeta parse(String paramString)
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
    this.alarmTime = Integer.valueOf(localObject[0][1]).intValue();
    this.alarmBigWriteTime = Integer.valueOf(localObject[0][2]).intValue();
    this.maintainCount = Integer.valueOf(localObject[0][3]).intValue();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.config.LogMeta
 * JD-Core Version:    0.7.0.1
 */