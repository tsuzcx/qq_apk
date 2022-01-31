package com.tencent.mobileqq.data;

public class DraftSummaryInfo
{
  private String atInfoStr;
  private String summary;
  private long time;
  private int type;
  private String uin;
  
  public String getAtInfoStr()
  {
    return this.atInfoStr;
  }
  
  public String getSummary()
  {
    return this.summary;
  }
  
  public long getTime()
  {
    return this.time / 1000L;
  }
  
  public void setAtInfoStr(String paramString)
  {
    this.atInfoStr = paramString;
  }
  
  public void setSummary(String paramString)
  {
    this.summary = paramString;
  }
  
  public void setTime(long paramLong)
  {
    this.time = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DraftSummaryInfo
 * JD-Core Version:    0.7.0.1
 */