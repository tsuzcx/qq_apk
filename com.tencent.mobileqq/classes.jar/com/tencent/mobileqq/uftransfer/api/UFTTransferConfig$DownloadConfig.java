package com.tencent.mobileqq.uftransfer.api;

public class UFTTransferConfig$DownloadConfig
{
  private UFTTransferConfig.ExtfDownloadCfg jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$ExtfDownloadCfg = new UFTTransferConfig.ExtfDownloadCfg();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownloadConfig{useExtf=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", useHttps=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", useIPv6=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", useMediaPlatform=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", extfCfg=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$ExtfDownloadCfg.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.DownloadConfig
 * JD-Core Version:    0.7.0.1
 */