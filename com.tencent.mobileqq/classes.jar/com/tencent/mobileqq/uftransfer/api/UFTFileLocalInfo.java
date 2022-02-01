package com.tencent.mobileqq.uftransfer.api;

import java.util.Arrays;

public class UFTFileLocalInfo
{
  private long a;
  private byte[] b;
  private byte[] c;
  private byte[] d;
  private byte[] e;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  
  public long a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public byte[] c()
  {
    return this.c;
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  public byte[] d()
  {
    return this.d;
  }
  
  public byte[] e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTFileLocalInfo{fileSize=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", bytes10mMd5=");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append(", bytesMd5=");
    localStringBuilder.append(Arrays.toString(this.c));
    localStringBuilder.append(", bytesSha3=");
    localStringBuilder.append(Arrays.toString(this.d));
    localStringBuilder.append(", bytesSha=");
    localStringBuilder.append(Arrays.toString(this.e));
    localStringBuilder.append(", with=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo
 * JD-Core Version:    0.7.0.1
 */