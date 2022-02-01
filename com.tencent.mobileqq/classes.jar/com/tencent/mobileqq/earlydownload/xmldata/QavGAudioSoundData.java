package com.tencent.mobileqq.earlydownload.xmldata;

public class QavGAudioSoundData
  extends XmlData
{
  @saveInSP(a=false, b=true)
  public boolean autoDownload = false;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.muteaudio";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.muteaudio";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavGAudioSoundData
 * JD-Core Version:    0.7.0.1
 */