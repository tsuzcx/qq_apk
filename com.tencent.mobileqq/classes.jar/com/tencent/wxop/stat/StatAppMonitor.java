package com.tencent.wxop.stat;

public class StatAppMonitor
  implements Cloneable
{
  public static final int FAILURE_RESULT_TYPE = 1;
  public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
  public static final int SUCCESS_RESULT_TYPE = 0;
  private String a = null;
  private long b = 0L;
  private long c = 0L;
  private int d = 0;
  private long e = 0L;
  private int f = 0;
  private int g = 1;
  
  public StatAppMonitor(String paramString)
  {
    this.a = paramString;
  }
  
  public StatAppMonitor(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, int paramInt3)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramInt1;
    this.e = paramLong3;
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public StatAppMonitor clone()
  {
    try
    {
      StatAppMonitor localStatAppMonitor = (StatAppMonitor)super.clone();
      return localStatAppMonitor;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public String getInterfaceName()
  {
    return this.a;
  }
  
  public long getMillisecondsConsume()
  {
    return this.e;
  }
  
  public long getReqSize()
  {
    return this.b;
  }
  
  public long getRespSize()
  {
    return this.c;
  }
  
  public int getResultType()
  {
    return this.d;
  }
  
  public int getReturnCode()
  {
    return this.f;
  }
  
  public int getSampling()
  {
    return this.g;
  }
  
  public void setInterfaceName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setMillisecondsConsume(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void setReqSize(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void setRespSize(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void setResultType(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setReturnCode(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setSampling(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.g = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.StatAppMonitor
 * JD-Core Version:    0.7.0.1
 */