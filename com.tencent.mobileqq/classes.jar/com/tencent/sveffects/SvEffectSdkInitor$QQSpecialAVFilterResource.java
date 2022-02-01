package com.tencent.sveffects;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;

public class SvEffectSdkInitor$QQSpecialAVFilterResource
  implements SpecialAVFilterResource
{
  public static final String STORAGE_DIR = AppConstants.SDCARD_ROOT + "/tencent/qq/music/";
  
  public String getMusicResPath()
  {
    return STORAGE_DIR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQSpecialAVFilterResource
 * JD-Core Version:    0.7.0.1
 */