package com.tencent.qapmsdk.base.reporter.ab;

import java.util.concurrent.ConcurrentHashMap;

public abstract class AbType
{
  public static final int PERF_TYPE_CPU = 1;
  public static final int PERF_TYPE_MEMORY = 4;
  public static final int PERF_TYPE_SMOOTH = 2;
  public static final String TAG = "QAPM.ABType";
  public long createTime = 9223372036854775807L;
  public ConcurrentHashMap<Integer, Long> timeOutMap = new ConcurrentHashMap();
  public String value = "";
  
  public abstract void active();
  
  public boolean canReportWith(int paramInt)
  {
    Long localLong = (Long)this.timeOutMap.get(Integer.valueOf(paramInt));
    if (localLong != null) {
      return System.currentTimeMillis() - this.createTime < localLong.longValue();
    }
    return false;
  }
  
  public abstract String getDescription();
  
  public void initValue(String paramString1, String paramString2)
  {
    this.createTime = System.currentTimeMillis();
    this.value = paramString1;
  }
  
  public void setPerfTimeout(int paramInt, long paramLong)
  {
    long l = paramLong;
    if (paramLong != 9223372036854775807L) {
      l = paramLong + (System.currentTimeMillis() - this.createTime);
    }
    this.timeOutMap.put(Integer.valueOf(paramInt), Long.valueOf(l));
  }
  
  public abstract void unActive();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ab.AbType
 * JD-Core Version:    0.7.0.1
 */