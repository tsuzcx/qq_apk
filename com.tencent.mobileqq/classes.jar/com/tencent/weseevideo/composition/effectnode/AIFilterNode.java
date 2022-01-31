package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.tavcut.aifilter.AIFilterModel;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

@Deprecated
public class AIFilterNode
  implements TAVVideoEffect
{
  private AIFilterModel mAIFilterModel;
  private final String sEffectId = "AIFilterNode" + Integer.toHexString(hashCode());
  
  public TAVVideoEffect.Filter createFilter()
  {
    Logger.i("TAVAIFilter", "creating");
    return new AIFilterNode.AIFilter(this);
  }
  
  @Nullable
  public String effectId()
  {
    if (this.mAIFilterModel == null) {
      return "";
    }
    return this.sEffectId;
  }
  
  public void setAIFilterModel(AIFilterModel paramAIFilterModel)
  {
    Logger.i("TAVAIFilter", "set ai filter model");
    this.mAIFilterModel = paramAIFilterModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.AIFilterNode
 * JD-Core Version:    0.7.0.1
 */