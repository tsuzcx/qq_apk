package com.tencent.mobileqq.earlydownload.xmldata;

public class PttSilkAndChangeVoiceSoData
  extends XmlData
{
  @saveInSP(a=true, b=true)
  public boolean amrV5So;
  @saveInSP(a=true, b=true)
  public boolean amrV7So;
  @saveInSP(a=true, b=true)
  public boolean amrV8So;
  @saveInSP(a=true, b=true)
  public boolean mipsSo;
  @saveInSP(a=true, b=true)
  public String version = "";
  @saveInSP(a=true, b=true)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.PttSilkAndChangeVoiceSoData
 * JD-Core Version:    0.7.0.1
 */