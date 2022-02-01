package com.tencent.mobileqq.earlydownload.xmldata;

import arov;

public class MiniScanDetectModeData
  extends XmlData
{
  @arov(a=true, b=true)
  public boolean block_user_download;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.minidetect.model_v8.2.0";
  }
  
  public String getStrResName()
  {
    return "qq.android.minidetect.model_v8.2.0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.MiniScanDetectModeData
 * JD-Core Version:    0.7.0.1
 */