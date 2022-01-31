package com.tencent.mobileqq.earlydownload.xmldata;

import amzv;

public class PttSilkAndChangeVoiceSoData
  extends XmlData
{
  @amzv(a=true, b=true)
  public boolean amrV5So;
  @amzv(a=true, b=true)
  public boolean amrV7So;
  @amzv(a=true, b=true)
  public boolean amrV8So;
  @amzv(a=true, b=true)
  public boolean mipsSo;
  @amzv(a=true, b=true)
  public String version = "";
  @amzv(a=true, b=true)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.PttSilkAndChangeVoiceSoData
 * JD-Core Version:    0.7.0.1
 */