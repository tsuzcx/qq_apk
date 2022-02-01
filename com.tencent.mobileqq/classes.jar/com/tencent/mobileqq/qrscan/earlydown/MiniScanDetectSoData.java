package com.tencent.mobileqq.qrscan.earlydown;

import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.earlydownload.xmldata.saveInSP;

public class MiniScanDetectSoData
  extends XmlData
{
  @saveInSP(a=true, b=true)
  public boolean block_user_download;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.minidetect.so_v8.6.0";
  }
  
  public String getStrResName()
  {
    return "qq.android.minidetect.so_v8.6.0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectSoData
 * JD-Core Version:    0.7.0.1
 */