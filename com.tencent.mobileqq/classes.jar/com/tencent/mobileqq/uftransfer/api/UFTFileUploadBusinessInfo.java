package com.tencent.mobileqq.uftransfer.api;

import java.util.Arrays;

public class UFTFileUploadBusinessInfo
{
  private String a;
  private String b;
  private String c;
  private int d = 0;
  private byte[] e;
  private boolean f = false;
  private String g;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public String d()
  {
    return this.g;
  }
  
  public String e()
  {
    return this.c;
  }
  
  public int f()
  {
    return this.d;
  }
  
  public byte[] g()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTFileUploadBusiInfo{fileId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadIp='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", svrPath='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", svrPathHostType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", checkKey=");
    localStringBuilder.append(Arrays.toString(this.e));
    localStringBuilder.append(", useMediaPlatform=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mediaPlatFileIdCrc='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo
 * JD-Core Version:    0.7.0.1
 */