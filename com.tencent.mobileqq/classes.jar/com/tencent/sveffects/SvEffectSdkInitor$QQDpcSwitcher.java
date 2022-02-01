package com.tencent.sveffects;

import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class SvEffectSdkInitor$QQDpcSwitcher
  implements DpcSwitcher
{
  public float getBeatyRate()
  {
    return MediaCodecDPC.a();
  }
  
  public boolean isBeautySwitchOpen()
  {
    return MediaCodecDPC.b();
  }
  
  public boolean isDeNoiseSwitchOpen()
  {
    return MediaCodecDPC.e();
  }
  
  public boolean isPortraitSwitchOpen()
  {
    return PtvFilterSoLoad.e();
  }
  
  public boolean isSvafSwitchOpen()
  {
    return MediaCodecDPC.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQDpcSwitcher
 * JD-Core Version:    0.7.0.1
 */