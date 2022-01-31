package com.tencent.tavkit.component.effectchain;

import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.List;

public class TAVVideoEffectContext
  implements IVideoEffectContext
{
  protected final VideoEffectProxy globalVideoEffectProxy = new VideoEffectProxy();
  protected final VideoEffectProxy sourceVideoEffectProxy = new VideoEffectProxy();
  protected final VideoMixEffectProxy videoMixEffectProxy = new VideoMixEffectProxy();
  
  public void addGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
  }
  
  public void addSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
  }
  
  public void addVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
  }
  
  public TAVVideoEffect getGlobalVideoEffect()
  {
    return this.globalVideoEffectProxy;
  }
  
  public TAVVideoEffect getSourceVideoEffect()
  {
    return this.sourceVideoEffectProxy;
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    return this.videoMixEffectProxy;
  }
  
  public void removeGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.globalVideoEffectProxy.notifyOnEffectRemove();
  }
  
  public void removeSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.sourceVideoEffectProxy.notifyOnEffectRemove();
  }
  
  public void removeVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    this.videoMixEffectProxy.notifyOnEffectRemove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.TAVVideoEffectContext
 * JD-Core Version:    0.7.0.1
 */