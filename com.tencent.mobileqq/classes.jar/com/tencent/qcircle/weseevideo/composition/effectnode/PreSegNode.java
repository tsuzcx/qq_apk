package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

public class PreSegNode
  implements TAVVideoEffect
{
  private static final String TAG = "PreSegNode";
  private CropModel cropModel;
  private final String mEffectId;
  private AEFilterManager outAEFilterManager;
  private PreSegNode.PicSaveDelegate picSaveDelegate;
  private PreSegModel preSegModel;
  private String reportKey;
  
  public PreSegNode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreSegNode");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.mEffectId = localStringBuilder.toString();
    this.reportKey = "PreSegNode";
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    Logger.i("PreSegNode", "createFilter---");
    return new PreSegNode.AEKitFilter(this, null);
  }
  
  @Nullable
  public String effectId()
  {
    return this.mEffectId;
  }
  
  public void setCropModel(CropModel paramCropModel)
  {
    this.cropModel = paramCropModel;
  }
  
  public void setFilterManager(AEFilterManager paramAEFilterManager)
  {
    this.outAEFilterManager = paramAEFilterManager;
  }
  
  public void setPicSaveDelegate(PreSegNode.PicSaveDelegate paramPicSaveDelegate)
  {
    this.picSaveDelegate = paramPicSaveDelegate;
  }
  
  public void setPreSegModel(PreSegModel paramPreSegModel)
  {
    this.preSegModel = paramPreSegModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.PreSegNode
 * JD-Core Version:    0.7.0.1
 */