package com.tencent.tgpa.vendorpd;

public class CombinationInfo
{
  public String cdnMD5;
  public String cdnUrl;
  public String gamePackageName;
  public String predownFileMD5;
  public String predownFilePath;
  
  public CombinationInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.cdnUrl = paramString1;
    this.cdnMD5 = paramString2;
    this.predownFilePath = paramString3;
    this.predownFileMD5 = paramString4;
    this.gamePackageName = paramString5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.CombinationInfo
 * JD-Core Version:    0.7.0.1
 */