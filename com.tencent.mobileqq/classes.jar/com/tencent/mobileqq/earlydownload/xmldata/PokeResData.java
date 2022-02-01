package com.tencent.mobileqq.earlydownload.xmldata;

import ascr;

public class PokeResData
  extends XmlData
{
  @ascr(a=true, b=true)
  public long SoLength;
  @ascr(a=true, b=true)
  public String SoMD5 = "";
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.poke.res_0625";
  }
  
  public String getStrResName()
  {
    return "qq.android.poke.res_0625";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.PokeResData
 * JD-Core Version:    0.7.0.1
 */