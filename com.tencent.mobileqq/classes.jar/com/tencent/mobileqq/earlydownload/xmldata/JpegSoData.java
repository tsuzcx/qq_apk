package com.tencent.mobileqq.earlydownload.xmldata;

import anpr;
import anqi;

public class JpegSoData
  extends XmlData
{
  @anqi(a=true, b=false)
  public String SO_MD5;
  
  public String getSharedPreferencesName()
  {
    return "early_" + anpr.e();
  }
  
  public String getStrResName()
  {
    return anpr.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.JpegSoData
 * JD-Core Version:    0.7.0.1
 */