package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;

public class QavSoData
  extends XmlData
{
  public String getSharedPreferencesName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload_");
    localStringBuilder.append(QavSoDownloadHandler.e());
    return localStringBuilder.toString();
  }
  
  public String getStrResName()
  {
    return QavSoDownloadHandler.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavSoData
 * JD-Core Version:    0.7.0.1
 */