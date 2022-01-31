package com.tencent.mobileqq.earlydownload.xmldata;

import aplz;

public class PttSilkAndChangeVoiceSoData
  extends XmlData
{
  @aplz(a=true, b=true)
  public boolean amrV5So;
  @aplz(a=true, b=true)
  public boolean amrV7So;
  @aplz(a=true, b=true)
  public boolean amrV8So;
  @aplz(a=true, b=true)
  public boolean mipsSo;
  @aplz(a=true, b=true)
  public String version = "";
  @aplz(a=true, b=true)
  public boolean x86So;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.ptt.so.658";
  }
  
  public String getStrResName()
  {
    return "qq.android.ptt.so.658";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.PttSilkAndChangeVoiceSoData
 * JD-Core Version:    0.7.0.1
 */