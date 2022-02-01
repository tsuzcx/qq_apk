package com.tencent.mobileqq.earlydownload.xmldata;

public class QavVideoData
  extends XmlData
{
  @saveInSP(a=false, b=true)
  public boolean autoDownload = false;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.video";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavVideoData
 * JD-Core Version:    0.7.0.1
 */