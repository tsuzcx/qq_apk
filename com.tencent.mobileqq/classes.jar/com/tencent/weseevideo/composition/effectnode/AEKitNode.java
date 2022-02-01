package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

public class AEKitNode
  implements TAVVideoEffect
{
  private static final String TAG = "AEKitNode";
  private AEKitModel mAEKitModel;
  private final String mEffectId = "AIFilterNode" + Integer.toHexString(hashCode());
  private String reportKey = "AEKitNode";
  
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
    Logger.i("AEKitNode", "setAEKitModel---: " + paramAEKitModel);
    this.mAEKitModel = paramAEKitModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.AEKitNode
 * JD-Core Version:    0.7.0.1
 */