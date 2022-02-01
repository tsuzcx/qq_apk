package com.tencent.mobileqq.uftransfer.api;

public class UFTTransferConfig
{
  private final boolean a;
  private final UFTTransferConfig.UploadConfig b = new UFTTransferConfig.UploadConfig();
  private final UFTTransferConfig.DownloadConfig c = new UFTTransferConfig.DownloadConfig();
  
  public UFTTransferConfig(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public UFTTransferConfig.UploadConfig a()
  {
    return this.b;
  }
  
  public String toString()
  {
    if (this.a)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("UFTTransferConfig{");
      localStringBuilder.append(this.b.toString());
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTTransferConfig{");
    localStringBuilder.append(this.c.toString());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTransferConfig
 * JD-Core Version:    0.7.0.1
 */