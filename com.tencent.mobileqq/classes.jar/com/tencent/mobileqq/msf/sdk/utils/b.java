package com.tencent.mobileqq.msf.sdk.utils;

public class b
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public long f;
  public int g;
  public String h;
  public byte i = 0;
  public int j;
  public long k;
  public Runnable l;
  
  public b() {}
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.b = paramString1;
    this.d = paramInt1;
    this.c = paramString2;
    this.e = paramInt2;
    this.f = paramLong;
    this.g = paramInt3;
  }
  
  public b a(long paramLong)
  {
    this.f += paramLong;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MonitorDataFlow{bufferSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mType='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ip='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", port=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", refer='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", keyHash='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", flag=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", networktype=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", processName='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastUpdateTime=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.b
 * JD-Core Version:    0.7.0.1
 */