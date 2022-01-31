package com.tencent.mobileqq.earlydownload.xmldata;

import amzv;

public class MiniScanDecodeSoData
  extends XmlData
{
  @amzv(a=true, b=true)
  public boolean block_user_download;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.minidecode.so_v8.1.5";
  }
  
  public String getStrResName()
  {
    return "qq.android.minidecode.so_v8.1.5";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.MiniScanDecodeSoData
 * JD-Core Version:    0.7.0.1
 */