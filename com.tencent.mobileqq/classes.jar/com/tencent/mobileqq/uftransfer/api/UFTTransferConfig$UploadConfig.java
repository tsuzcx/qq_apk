package com.tencent.mobileqq.uftransfer.api;

public class UFTTransferConfig$UploadConfig
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private UFTTransferConfig.ExtfUploadCfg g = new UFTTransferConfig.ExtfUploadCfg();
  
  public void a(UFTTransferConfig.ExtfUploadCfg paramExtfUploadCfg)
  {
    this.g = paramExtfUploadCfg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public void f(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public UFTTransferConfig.ExtfUploadCfg g()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UploadConfig{useExtf=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", extfSafeGuard=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", useHttps=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", useIPv6=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ftnSpeedTest=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", useMediaPlatform=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", extfCfg=");
    localStringBuilder.append(this.g.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig
 * JD-Core Version:    0.7.0.1
 */