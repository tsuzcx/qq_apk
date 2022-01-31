package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.weseevideo.model.effect.CropModel;

public class CropEffectNode
  implements TAVVideoEffect
{
  private CropModel mCropModel;
  protected String reportKey = "CropEffectNode";
  private final String sEffectId = "CropEffectNode" + Integer.toHexString(hashCode());
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new CropEffectNode.CropEffectFilter(this);
  }
  
  @Nullable
  public String effectId()
  {
    if (this.mCropModel == null) {
      return "";
    }
    return this.sEffectId;
  }
  
  public CropModel getCropModel()
  {
    return this.mCropModel;
  }
  
  public void setCropModel(CropModel paramCropModel)
  {
    this.mCropModel = paramCropModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.CropEffectNode
 * JD-Core Version:    0.7.0.1
 */