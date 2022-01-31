package com.tencent.weseevideo.model.effect;

import com.tencent.tavcut.bean.CropConfig;
import com.tencent.weseevideo.composition.effectnode.VideoEffectType;

public class CropModel
  extends BaseEffectModel
{
  private CropConfig cropConfig;
  private int effectType = VideoEffectType.TYPE_CROP.value;
  
  public CropConfig getCropConfig()
  {
    return this.cropConfig;
  }
  
  public void setCropConfig(CropConfig paramCropConfig)
  {
    this.cropConfig = paramCropConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.CropModel
 * JD-Core Version:    0.7.0.1
 */