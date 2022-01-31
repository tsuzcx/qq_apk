package com.tencent.mobileqq.msf.core;

public class h$a
{
  public int a;
  public long b;
  public long c;
  public long d;
  public long e = -1L;
  public boolean f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("logInfoContext, stat:").append(this.a).append(", reqSeq:").append(this.b).append(", logSize:").append(this.c).append(", zipLogSize:").append(this.d).append(", failCode:").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.h.a
 * JD-Core Version:    0.7.0.1
 */