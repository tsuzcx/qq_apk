package com.tencent.mobileqq.uftransfer.proto;

public class UFTC2CUploadBaseInfo
{
  private long a = 0L;
  private long b = 0L;
  private boolean c = false;
  private long d = 0L;
  private byte[] e;
  private String f;
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  public long c()
  {
    return this.a;
  }
  
  public void c(long paramLong)
  {
    this.d = paramLong;
  }
  
  public long d()
  {
    return this.b;
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public long f()
  {
    return this.d;
  }
  
  public byte[] g()
  {
    return this.e;
  }
  
  public String h()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadBaseInfo
 * JD-Core Version:    0.7.0.1
 */