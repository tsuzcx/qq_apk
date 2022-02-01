package com.tencent.mobileqq.earlydownload.xmldata;

public class PttSilkAndChangeVoiceSoData
  extends XmlData
{
  @saveInSP(a=true, b=true)
  public boolean amrV5So = false;
  @saveInSP(a=true, b=true)
  public boolean amrV7So = false;
  @saveInSP(a=true, b=true)
  public boolean amrV8So = false;
  @saveInSP(a=true, b=true)
  public boolean mipsSo = false;
  @saveInSP(a=true, b=true)
  public String version = "";
  @saveInSP(a=true, b=true)
  public boolean x86So = false;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.ptt.so.658";
  }
  
  public String getStrResName()
  {
    return "qq.android.ptt.so.658";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.PttSilkAndChangeVoiceSoData
 * JD-Core Version:    0.7.0.1
 */