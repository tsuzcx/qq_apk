package com.tencent.mobileqq.servlet.model;

import java.util.Map;

public class SinglePushMsg
{
  public long a = 0L;
  public Map<String, String> b = null;
  public long c = 0L;
  public int d = 0;
  public boolean e = false;
  public boolean f = false;
  public String g;
  public byte[] h = null;
  
  public SinglePushMsg(long paramLong1, Map<String, String> paramMap, long paramLong2, String paramString)
  {
    this.a = paramLong1;
    this.b = paramMap;
    this.c = paramLong2;
    this.g = paramString;
  }
  
  public SinglePushMsg(long paramLong1, Map<String, String> paramMap, long paramLong2, String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramLong1;
    this.b = paramMap;
    this.c = paramLong2;
    this.g = paramString;
    this.h = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.model.SinglePushMsg
 * JD-Core Version:    0.7.0.1
 */