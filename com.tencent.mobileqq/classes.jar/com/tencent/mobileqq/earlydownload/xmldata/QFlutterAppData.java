package com.tencent.mobileqq.earlydownload.xmldata;

import anqd;

public class QFlutterAppData
  extends XmlData
{
  @anqd(a=true, b=true)
  public String assetResMD5 = "";
  @anqd(a=true, b=true)
  public String libAppSoMD5 = "";
  @anqd(a=true, b=true)
  public String libSkinSoMD5 = "";
  
  public String getSharedPreferencesName()
  {
    return "early_qflutter_app_downloader_sp";
  }
  
  public String getStrResName()
  {
    return "qq.android.flutter.app.v8.2.8";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData
 * JD-Core Version:    0.7.0.1
 */