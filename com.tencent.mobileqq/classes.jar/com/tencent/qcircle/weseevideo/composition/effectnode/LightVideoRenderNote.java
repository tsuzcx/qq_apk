package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.support.annotation.Nullable;
import com.tencent.qcircle.weseevideo.composition.interfaces.OnNodeRenderListener;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import org.light.LightAsset;
import org.light.LightEngine;

public class LightVideoRenderNote
  implements TAVVideoEffect
{
  private static final int SHORT_EDGE_LENGTH = 180;
  private LightAsset mLightAsset;
  private final LightEngine mLightEngine;
  private OnNodeRenderListener mOnNodeRenderListener;
  private final String mTAG;
  
  public LightVideoRenderNote(LightEngine paramLightEngine)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LightVideoRenderNote@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.mTAG = localStringBuilder.toString();
    this.mLightEngine = paramLightEngine;
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new LightVideoRenderNote.LightVideoRenderFilter(this.mLightEngine, this.mOnNodeRenderListener, this.mLightAsset);
  }
  
  @Nullable
  public String effectId()
  {
    return this.mTAG;
  }
  
  public void setLightAsset(LightAsset paramLightAsset)
  {
    this.mLightAsset = paramLightAsset;
  }
  
  public void setOnNodeRenderListener(OnNodeRenderListener paramOnNodeRenderListener)
  {
    this.mOnNodeRenderListener = paramOnNodeRenderListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.LightVideoRenderNote
 * JD-Core Version:    0.7.0.1
 */