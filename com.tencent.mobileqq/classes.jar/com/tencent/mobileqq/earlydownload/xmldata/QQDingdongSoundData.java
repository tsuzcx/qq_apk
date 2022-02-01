package com.tencent.mobileqq.earlydownload.xmldata;

import aqyh;

public class QQDingdongSoundData
  extends XmlData
{
  @aqyh(a=false, b=true)
  public boolean autoDownload;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.dingdong.ring";
  }
  
  public String getStrResName()
  {
    return "qq.android.dingdong.ring";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QQDingdongSoundData
 * JD-Core Version:    0.7.0.1
 */