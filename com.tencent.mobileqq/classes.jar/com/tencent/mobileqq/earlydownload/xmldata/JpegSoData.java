package com.tencent.mobileqq.earlydownload.xmldata;

import arod;
import arov;

public class JpegSoData
  extends XmlData
{
  @arov(a=true, b=false)
  public String SO_MD5;
  
  public String getSharedPreferencesName()
  {
    return "early_" + arod.e();
  }
  
  public String getStrResName()
  {
    return arod.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.JpegSoData
 * JD-Core Version:    0.7.0.1
 */