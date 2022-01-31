package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

public class AEKitNode
  implements TAVVideoEffect
{
  private AEKitModel mAEKitModel;
  protected String reportKey = "AEKitNode";
  private final String sEffectId = "AIFilterNode" + Integer.toHexString(hashCode());
  
  public TAVVideoEffect.Filter createFilter()
  {
    Logger.i("TAVAIFilter", "creating");
    return new AEKitNode.AEKitFilter(this, null);
  }
  
  @Nullable
  public String effectId()
  {
    if (this.mAEKitModel == null) {
      return "";
    }
    return this.sEffectId;
  }
  
  public void setAEKitModel(AEKitModel paramAEKitModel)
  {
    Logger.i("AEKitNode", "set aekit model");
    this.mAEKitModel = paramAEKitModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.AEKitNode
 * JD-Core Version:    0.7.0.1
 */