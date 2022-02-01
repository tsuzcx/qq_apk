package com.tencent.mobileqq.earlydownload.xmldata;

import ascr;

public class QavImageData
  extends XmlData
{
  @ascr(a=false, b=true)
  public boolean autoDownload;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.image2";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.image2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavImageData
 * JD-Core Version:    0.7.0.1
 */