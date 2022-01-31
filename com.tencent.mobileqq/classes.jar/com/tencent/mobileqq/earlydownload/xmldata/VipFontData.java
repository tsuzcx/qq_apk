package com.tencent.mobileqq.earlydownload.xmldata;

public class VipFontData
  extends XmlData
{
  public static final String VIP_FONT_SP_NAME = "early_qq.android.native.vipfont.v5";
  @saveInSP(a=true, b=true)
  public String SoMD5;
  @saveInSP(a=false, b=true)
  public boolean vip_font_so_downloaded;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.native.vipfont.v5";
  }
  
  public String getStrResName()
  {
    return "qq.android.native.vipfont.v5";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.VipFontData
 * JD-Core Version:    0.7.0.1
 */