package com.tencent.mobileqq.earlydownload.xmldata;

import aplz;

public class PttTransitonAnimData
  extends XmlData
{
  @aplz(a=false, b=true)
  public boolean autoDownload;
  public boolean isUserClick = true;
  
  public String getSharedPreferencesName()
  {
    return "early_ptt.transition.anim.res.zip";
  }
  
  public String getStrResName()
  {
    return "ptt.transition.anim.res.zip";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.PttTransitonAnimData
 * JD-Core Version:    0.7.0.1
 */