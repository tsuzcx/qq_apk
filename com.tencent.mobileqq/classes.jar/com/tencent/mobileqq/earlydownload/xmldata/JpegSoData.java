package com.tencent.mobileqq.earlydownload.xmldata;

import asbz;
import ascr;

public class JpegSoData
  extends XmlData
{
  @ascr(a=true, b=false)
  public String SO_MD5;
  
  public String getSharedPreferencesName()
  {
    return "early_" + asbz.e();
  }
  
  public String getStrResName()
  {
    return asbz.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.JpegSoData
 * JD-Core Version:    0.7.0.1
 */