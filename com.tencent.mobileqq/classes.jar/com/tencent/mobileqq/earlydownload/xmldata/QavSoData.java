package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;

public class QavSoData
  extends QavSoDataBase
{
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.so";
  }
  
  public String getStrResName()
  {
    return QavSoDownloadHandler.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavSoData
 * JD-Core Version:    0.7.0.1
 */