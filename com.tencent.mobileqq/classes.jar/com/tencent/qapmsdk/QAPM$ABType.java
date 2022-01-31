package com.tencent.qapmsdk;

import java.util.concurrent.ConcurrentHashMap;

public abstract class QAPM$ABType
{
  public static final int PERFTYPE_CPU = 1;
  public static final int PERTYPE_MEMORY = 4;
  public static final int PERTYPE_SMOOTH = 2;
  public static final String TAG = "QAPM.ABType";
  public long createTime = 9223372036854775807L;
  public ConcurrentHashMap<Integer, Long> mTimeOutMap = new ConcurrentHashMap();
  public String value = "";
  
  public abstract void active();
  
  public boolean canReportWith(int paramInt)
  {
    Long localLong = (Long)this.mTimeOutMap.get(Integer.valueOf(paramInt));
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
    this.mTimeOutMap.put(Integer.valueOf(paramInt), Long.valueOf(l));
  }
  
  public abstract void unactive();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.QAPM.ABType
 * JD-Core Version:    0.7.0.1
 */