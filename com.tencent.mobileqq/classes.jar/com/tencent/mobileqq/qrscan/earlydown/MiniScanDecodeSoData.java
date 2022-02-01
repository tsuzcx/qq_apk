package com.tencent.mobileqq.qrscan.earlydown;

import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.earlydownload.xmldata.saveInSP;

public class MiniScanDecodeSoData
  extends XmlData
{
  @saveInSP(a=true, b=true)
  public boolean block_user_download;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.minidecode.so_v8.8.5";
  }
  
  public String getStrResName()
  {
    return "qq.android.minidecode.so_v8.8.5";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.MiniScanDecodeSoData
 * JD-Core Version:    0.7.0.1
 */