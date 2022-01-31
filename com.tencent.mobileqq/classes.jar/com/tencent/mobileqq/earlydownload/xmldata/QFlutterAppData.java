package com.tencent.mobileqq.earlydownload.xmldata;

import aplz;

public class QFlutterAppData
  extends XmlData
{
  @aplz(a=true, b=true)
  public String assetResMD5 = "";
  @aplz(a=true, b=true)
  public String libAppSoMD5 = "";
  @aplz(a=true, b=true)
  public String libSkinSoMD5 = "";
  
  public String getSharedPreferencesName()
  {
    return "early_qflutter_app_downloader_sp";
  }
  
  public String getStrResName()
  {
    return "qq.android.flutter.app.v8.3.3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData
 * JD-Core Version:    0.7.0.1
 */