package com.tencent.mobileqq.uftransfer.api;

public class UFTTransferConfig$ExtfUploadCfg
{
  private long a = 10485760L;
  private int b = 3;
  private int c = 524288;
  private int d = 200;
  private int e = 27;
  private int f = 10;
  private long g = 7000L;
  private long h = 21000L;
  private long i = 120000L;
  
  public long a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.g = paramLong;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.h = paramLong;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.i = paramLong;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public void e(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public long g()
  {
    return this.g;
  }
  
  public long h()
  {
    return this.h;
  }
  
  public long i()
  {
    return this.i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtfUploadCfg{muliFileSizeLimit=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", maxChannelNum=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", pieceSize=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", maxEachHostTotalUseCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", maxEachHostErrorCount=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", maxEachHostParallelUseCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", connectTimeout=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", dataTimeout=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", totoalDataTimeout=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.ExtfUploadCfg
 * JD-Core Version:    0.7.0.1
 */