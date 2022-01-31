package com.tencent.mobileqq.earlydownload.xmldata;

import anqd;

public class QFlutterEngineData
  extends XmlData
{
  @anqd(a=true, b=true)
  public String libEngineSoMD5 = "";
  
  public String getSharedPreferencesName()
  {
    return "early_qflutter_engine_downloader_sp";
  }
  
  public String getStrResName()
  {
    return "qq.android.flutter.engine.v8.2.8";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData
 * JD-Core Version:    0.7.0.1
 */