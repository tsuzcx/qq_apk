package com.tencent.sveffects;

import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class SvEffectSdkInitor$QQDpcSwitcher
  implements DpcSwitcher
{
  public float getBeatyRate()
  {
    return ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getBeatyRate();
  }
  
  public boolean isBeautySwitchOpen()
  {
    return ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isBeautySwitchOpen();
  }
  
  public boolean isDeNoiseSwitchOpen()
  {
    return ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isDeNoiseSwitchOpen();
  }
  
  public boolean isPortraitSwitchOpen()
  {
    return PtvFilterSoLoad.h();
  }
  
  public boolean isSvafSwitchOpen()
  {
    return ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isSvafSwitchOpen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQDpcSwitcher
 * JD-Core Version:    0.7.0.1
 */