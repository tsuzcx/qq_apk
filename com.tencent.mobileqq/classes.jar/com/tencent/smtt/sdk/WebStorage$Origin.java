package com.tencent.smtt.sdk;

public class WebStorage$Origin
{
  private String mOrigin = null;
  private long mQuota = 0L;
  private long mUsage = 0L;
  
  protected WebStorage$Origin(String paramString)
  {
    this.mOrigin = paramString;
  }
  
  protected WebStorage$Origin(String paramString, long paramLong)
  {
    this.mOrigin = paramString;
    this.mQuota = paramLong;
  }
  
  protected WebStorage$Origin(String paramString, long paramLong1, long paramLong2)
  {
    this.mOrigin = paramString;
    this.mQuota = paramLong1;
    this.mUsage = paramLong2;
  }
  
  public String getOrigin()
  {
    return this.mOrigin;
  }
  
  public long getQuota()
  {
    return this.mQuota;
  }
  
  public long getUsage()
  {
    return this.mUsage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebStorage.Origin
 * JD-Core Version:    0.7.0.1
 */