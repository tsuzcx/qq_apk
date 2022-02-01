package com.tencent.mobileqq.earlydownload.xmldata;

import asej;

public class QFlutterAppData
  extends XmlData
{
  @asej(a=true, b=true)
  public String assetResMD5 = "";
  @asej(a=true, b=true)
  public String libAppSoMD5 = "";
  @asej(a=true, b=true)
  public String libSkinSoMD5 = "";
  
  public String getSharedPreferencesName()
  {
    return "early_qflutter_app_downloader_sp";
  }
  
  public String getStrResName()
  {
    return "qq.android.flutter.app.v8.3.9";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData
 * JD-Core Version:    0.7.0.1
 */