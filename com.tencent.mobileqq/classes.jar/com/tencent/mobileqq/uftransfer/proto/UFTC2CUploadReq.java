package com.tencent.mobileqq.uftransfer.proto;

public class UFTC2CUploadReq
  extends UFTC2CUploadBaseInfo
{
  private long a = 0L;
  private String b;
  private String c;
  private byte[] d;
  private byte[] e;
  private byte[] f;
  private byte[] g;
  private int h = 0;
  private long i = 0L;
  
  public long a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  public void d(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    this.f = paramArrayOfByte;
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    this.g = paramArrayOfByte;
  }
  
  public byte[] i()
  {
    return this.d;
  }
  
  public byte[] j()
  {
    return this.e;
  }
  
  public byte[] k()
  {
    return this.f;
  }
  
  public byte[] l()
  {
    return this.g;
  }
  
  public String m()
  {
    return this.c;
  }
  
  public int n()
  {
    return this.h;
  }
  
  public long o()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadReq
 * JD-Core Version:    0.7.0.1
 */