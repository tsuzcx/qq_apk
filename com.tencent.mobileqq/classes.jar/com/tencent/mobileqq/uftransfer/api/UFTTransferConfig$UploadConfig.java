package com.tencent.mobileqq.uftransfer.api;

public class UFTTransferConfig$UploadConfig
{
  private UFTTransferConfig.ExtfUploadCfg jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$ExtfUploadCfg = new UFTTransferConfig.ExtfUploadCfg();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  
  public UFTTransferConfig.ExtfUploadCfg a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$ExtfUploadCfg;
  }
  
  public void a(UFTTransferConfig.ExtfUploadCfg paramExtfUploadCfg)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$ExtfUploadCfg = paramExtfUploadCfg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UploadConfig{useExtf=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
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
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$ExtfUploadCfg.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig
 * JD-Core Version:    0.7.0.1
 */