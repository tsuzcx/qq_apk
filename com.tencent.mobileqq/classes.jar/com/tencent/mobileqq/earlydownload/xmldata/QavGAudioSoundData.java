package com.tencent.mobileqq.earlydownload.xmldata;

import asej;

public class QavGAudioSoundData
  extends XmlData
{
  @asej(a=false, b=true)
  public boolean autoDownload;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.muteaudio";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.muteaudio";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavGAudioSoundData
 * JD-Core Version:    0.7.0.1
 */