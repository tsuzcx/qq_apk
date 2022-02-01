package com.tencent.mobileqq.qassistant.data;

public class ConfirmSendInfo
{
  public long a;
  public long b;
  public String c;
  
  public ConfirmSendInfo(long paramLong1, long paramLong2, String paramString)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramString;
  }
  
  public String a()
  {
    return String.format("[voiceIdx:%s, bTime:%s, eTime:%s]", new Object[] { this.c, Long.valueOf(this.a), Long.valueOf(this.b) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.data.ConfirmSendInfo
 * JD-Core Version:    0.7.0.1
 */