package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.earlydownload.handler.JpegSoDownloadHandler;

public class JpegSoData
  extends XmlData
{
  @saveInSP(a=true, b=false)
  public String SO_MD5;
  
  public String getSharedPreferencesName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("early_");
    localStringBuilder.append(JpegSoDownloadHandler.w());
    return localStringBuilder.toString();
  }
  
  public String getStrResName()
  {
    return JpegSoDownloadHandler.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.JpegSoData
 * JD-Core Version:    0.7.0.1
 */