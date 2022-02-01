package com.tencent.mobileqq.uftransfer.api;

public class UFTTransferConfig
{
  private final UFTTransferConfig.DownloadConfig jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$DownloadConfig = new UFTTransferConfig.DownloadConfig();
  private final UFTTransferConfig.UploadConfig jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$UploadConfig = new UFTTransferConfig.UploadConfig();
  private final boolean jdField_a_of_type_Boolean;
  
  public UFTTransferConfig(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public UFTTransferConfig.UploadConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$UploadConfig;
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("UFTTransferConfig{");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$UploadConfig.toString());
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTTransferConfig{");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$DownloadConfig.toString());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTransferConfig
 * JD-Core Version:    0.7.0.1
 */