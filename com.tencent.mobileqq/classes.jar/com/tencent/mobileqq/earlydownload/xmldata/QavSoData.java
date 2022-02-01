package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;

public class QavSoData
  extends XmlData
{
  public String getSharedPreferencesName()
  {
    return "preload_" + QavSoDownloadHandler.e();
  }
  
  public String getStrResName()
  {
    return QavSoDownloadHandler.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavSoData
 * JD-Core Version:    0.7.0.1
 */