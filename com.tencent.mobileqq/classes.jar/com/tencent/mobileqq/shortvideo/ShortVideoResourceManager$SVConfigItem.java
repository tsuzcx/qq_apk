package com.tencent.mobileqq.shortvideo;

public class ShortVideoResourceManager$SVConfigItem
{
  public String arm_md5;
  public String arm_url;
  public String armv7a_md5;
  public String armv7a_url;
  public String extend1;
  public String extend2;
  public String name;
  public boolean predownload;
  public int versionCode;
  public String x86_md5;
  public String x86_url;
  
  public String getSignature()
  {
    return this.armv7a_md5 + '_' + this.versionCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem
 * JD-Core Version:    0.7.0.1
 */