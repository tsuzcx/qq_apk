package com.tencent.qphone.base.util.log.a;

public class b$a
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
    localStringBuilder.append("logInfoContext, stat:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", reqSeq:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", logSize:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", zipLogSize:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", failCode:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.b.a
 * JD-Core Version:    0.7.0.1
 */