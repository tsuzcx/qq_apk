package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

public class AEKitNode
  implements TAVVideoEffect
{
  private static final String TAG = "AEKitNode";
  private boolean isBasePicActive;
  private AEKitModel mAEKitModel;
  private final String mEffectId;
  private AEFilterManager outAEFilterManager;
  private String reportKey;
  
  public AEKitNode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AIFilterNode");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.mEffectId = localStringBuilder.toString();
    this.reportKey = "AEKitNode";
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    Logger.i("AEKitNode", "createFilter---");
    return new AEKitNode.AEKitFilter(this, null);
  }
  
  @Nullable
  public String effectId()
  {
    return this.mEffectId;
  }
  
  public void setAEKitModel(AEKitModel paramAEKitModel)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAEKitModel---: ");
    localStringBuilder.append(paramAEKitModel);
    Logger.i("AEKitNode", localStringBuilder.toString());
    this.mAEKitModel = paramAEKitModel;
  }
  
  public void setBasePicActive(boolean paramBoolean)
  {
    this.isBasePicActive = paramBoolean;
  }
  
  public void setFilterManager(AEFilterManager paramAEFilterManager)
  {
    this.outAEFilterManager = paramAEFilterManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.AEKitNode
 * JD-Core Version:    0.7.0.1
 */