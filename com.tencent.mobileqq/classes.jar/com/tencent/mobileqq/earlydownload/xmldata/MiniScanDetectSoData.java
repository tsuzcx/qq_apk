package com.tencent.mobileqq.earlydownload.xmldata;

import aphq;

public class MiniScanDetectSoData
  extends XmlData
{
  @aphq(a=true, b=true)
  public boolean block_user_download;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.minidetect.so_v8.2.0";
  }
  
  public String getStrResName()
  {
    return "qq.android.minidetect.so_v8.2.0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.MiniScanDetectSoData
 * JD-Core Version:    0.7.0.1
 */