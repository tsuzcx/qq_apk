package com.tencent.mobileqq.uftransfer.api;

import java.util.Arrays;

public class UFTC2CUploadInfo
  extends UFTBaseUploadInfo
{
  private long a = -1L;
  private byte[] b;
  private String c;
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public long g()
  {
    return this.a;
  }
  
  public byte[] h()
  {
    return this.b;
  }
  
  public String i()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTC2CUploadInfo{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", tempSessionType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tmpSessionSig=");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append(", tmpSessionToPhone='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTC2CUploadInfo
 * JD-Core Version:    0.7.0.1
 */