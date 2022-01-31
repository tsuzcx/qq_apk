package com.tencent.mobileqq.earlydownload.xmldata;

public class ApngData
  extends XmlData
{
  public static final String SP_NAME = "early_qq.android.native.apng_v700";
  @saveInSP(a=true, b=true)
  public String SoMD5;
  @saveInSP(a=false, b=true)
  public boolean apng_so_downloaded;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.native.apng_v700";
  }
  
  public String getStrResName()
  {
    return "qq.android.native.apng_v700";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.ApngData
 * JD-Core Version:    0.7.0.1
 */