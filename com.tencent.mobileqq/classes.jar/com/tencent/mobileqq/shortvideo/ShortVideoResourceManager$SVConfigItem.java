package com.tencent.mobileqq.shortvideo;

import azfg;
import bdnn;

public class ShortVideoResourceManager$SVConfigItem
{
  public String arm64v8a_md5;
  public String arm64v8a_url;
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
  
  public boolean check64BitReady()
  {
    return (!bdnn.a(this.arm64v8a_md5)) && (!bdnn.a(this.arm64v8a_url));
  }
  
  public String getSignature()
  {
    if ((azfg.a()) && (check64BitReady())) {
      return this.arm64v8a_md5 + '_' + this.versionCode;
    }
    return this.armv7a_md5 + '_' + this.versionCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem
 * JD-Core Version:    0.7.0.1
 */