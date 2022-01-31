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
    return "MonitorDataFlow{bufferSize=" + this.f + ", mType='" + this.h + '\'' + ", ip='" + this.b + '\'' + ", port=" + this.d + ", refer='" + this.c + '\'' + ", keyHash='" + this.j + '\'' + ", flag=" + this.e + ", networktype=" + this.g + ", status=" + this.i + ", processName='" + this.a + '\'' + ", lastUpdateTime=" + this.k + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.b
 * JD-Core Version:    0.7.0.1
 */