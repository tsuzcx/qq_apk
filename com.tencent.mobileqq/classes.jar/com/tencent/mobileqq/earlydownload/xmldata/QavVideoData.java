package com.tencent.mobileqq.earlydownload.xmldata;

import asej;

public class QavVideoData
  extends XmlData
{
  @asej(a=false, b=true)
  public boolean autoDownload;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.video";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavVideoData
 * JD-Core Version:    0.7.0.1
 */