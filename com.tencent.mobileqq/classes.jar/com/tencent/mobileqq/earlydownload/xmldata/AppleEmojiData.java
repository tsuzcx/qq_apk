package com.tencent.mobileqq.earlydownload.xmldata;

import amzv;

public class AppleEmojiData
  extends XmlData
{
  @amzv(a=true, b=false)
  public String v7a_MD5;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.appleemoji";
  }
  
  public String getStrResName()
  {
    return "qq.android.appleemoji";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData
 * JD-Core Version:    0.7.0.1
 */