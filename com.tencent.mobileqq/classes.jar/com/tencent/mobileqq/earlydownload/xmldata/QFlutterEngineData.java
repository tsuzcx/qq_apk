package com.tencent.mobileqq.earlydownload.xmldata;

import aphq;

public class QFlutterEngineData
  extends XmlData
{
  @aphq(a=true, b=true)
  public String libEngineSoMD5 = "";
  
  public String getSharedPreferencesName()
  {
    return "early_qflutter_engine_downloader_sp";
  }
  
  public String getStrResName()
  {
    return "qq.android.flutter.engine.v8.3.3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData
 * JD-Core Version:    0.7.0.1
 */