package com.tencent.mobileqq.earlydownload.xmldata;

import aplh;
import aplz;

public class JpegSoData
  extends XmlData
{
  @aplz(a=true, b=false)
  public String SO_MD5;
  
  public String getSharedPreferencesName()
  {
    return "early_" + aplh.e();
  }
  
  public String getStrResName()
  {
    return aplh.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.JpegSoData
 * JD-Core Version:    0.7.0.1
 */