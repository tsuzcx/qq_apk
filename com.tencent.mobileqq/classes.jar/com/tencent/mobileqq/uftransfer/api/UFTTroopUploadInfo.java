package com.tencent.mobileqq.uftransfer.api;

import java.util.Arrays;

public class UFTTroopUploadInfo
  extends UFTBaseUploadInfo
{
  private int a;
  private String b;
  private long c = 0L;
  private String d;
  private String e;
  private byte[] f;
  private byte[] g;
  private byte[] h;
  private int i = 0;
  
  public void a(byte[] paramArrayOfByte)
  {
    this.f = paramArrayOfByte;
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.g = paramArrayOfByte;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.h = paramArrayOfByte;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public int g()
  {
    return this.a;
  }
  
  public String h()
  {
    return this.b;
  }
  
  public String i()
  {
    return this.d;
  }
  
  public String j()
  {
    return this.e;
  }
  
  public int k()
  {
    return this.i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTTroopUploadInfo{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", busId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", strParentId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", troopCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", fileId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverDns='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bytesSha=");
    localStringBuilder.append(Arrays.toString(this.f));
    localStringBuilder.append(", bytesMd5=");
    localStringBuilder.append(Arrays.toString(this.g));
    localStringBuilder.append(", bytesSha3=");
    localStringBuilder.append(Arrays.toString(this.h));
    localStringBuilder.append(", entranceType=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo
 * JD-Core Version:    0.7.0.1
 */