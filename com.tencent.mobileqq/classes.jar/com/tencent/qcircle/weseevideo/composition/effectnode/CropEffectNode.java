package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

public class CropEffectNode
  implements TAVVideoEffect
{
  private CropModel mCropModel;
  protected String reportKey;
  private final String sEffectId;
  
  public CropEffectNode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CropEffectNode");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.sEffectId = localStringBuilder.toString();
    this.reportKey = "CropEffectNode";
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.CropEffectNode
 * JD-Core Version:    0.7.0.1
 */