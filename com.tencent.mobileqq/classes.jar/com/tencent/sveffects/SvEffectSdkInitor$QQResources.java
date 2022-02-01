package com.tencent.sveffects;

import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.BeautyResource;
import com.tencent.mobileqq.shortvideo.resource.GestureGameResource;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.LowLightResource;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;

public class SvEffectSdkInitor$QQResources
  implements Resources
{
  public SpecialAVFilterResource getAVFilterResource()
  {
    return new SvEffectSdkInitor.QQSpecialAVFilterResource();
  }
  
  public ArtFilterResource getArtFilterResource()
  {
    return new SvEffectSdkInitor.QQArtFilterResource();
  }
  
  public AVFilterResource getAvFilterResource()
  {
    return new SvEffectSdkInitor.QQAVFilterResource();
  }
  
  public BeautyResource getBeautyResource()
  {
    return new SvEffectSdkInitor.QQBeautyResource();
  }
  
  public GestureResource getGestureResource()
  {
    return new SvEffectSdkInitor.QQGestureResource();
  }
  
  public LowLightResource getLowLightResource()
  {
    return new SvEffectSdkInitor.QQLowLightResource();
  }
  
  public PtuFilterResource getPtuFilterResource()
  {
    return new SvEffectSdkInitor.QQPtuFilterResource();
  }
  
  public SensorResource getSensorResource()
  {
    return new SvEffectSdkInitor.QQSenorResource();
  }
  
  public GestureGameResource geteGestureGameResource()
  {
    return new SvEffectSdkInitor.QQGestureGameResource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQResources
 * JD-Core Version:    0.7.0.1
 */