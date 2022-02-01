package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.filament.FilamentFilter;
import com.tencent.ttpic.filter.FabbyFilters;
import com.tencent.ttpic.filter.FabbyStrokeFilterExt;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.VoiceTextFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.particle.ParticleFilter;
import com.tencent.ttpic.particle.ParticleFilter3D;
import com.tencent.ttpic.trigger.FabbyFiltersTriggerCtrlItem;
import com.tencent.ttpic.trigger.FabbyStrokeExtTriggerCtrlItem;
import com.tencent.ttpic.trigger.FilamentTriggerCtrlItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.trigger.VoiceToTextTriggerCtrlItem;

public class RenderItem
{
  public AEFilterI filter;
  public TriggerCtrlItem triggerCtrlItem;
  
  public RenderItem(AEFilterI paramAEFilterI, TriggerCtrlItem paramTriggerCtrlItem)
  {
    this.filter = paramAEFilterI;
    this.triggerCtrlItem = paramTriggerCtrlItem;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    if (this.filter == null) {
      return paramFrame;
    }
    TriggerCtrlItem localTriggerCtrlItem = this.triggerCtrlItem;
    if ((localTriggerCtrlItem != null) && (!localTriggerCtrlItem.isTriggered())) {
      return paramFrame;
    }
    return this.filter.RenderProcess(paramFrame);
  }
  
  public void apply() {}
  
  public void clear() {}
  
  public void updatePreview(Object paramObject)
  {
    Object localObject1 = this.filter;
    Object localObject2;
    if ((localObject1 instanceof NormalVideoFilter))
    {
      localObject2 = this.triggerCtrlItem;
      if (localObject2 != null)
      {
        ((NormalVideoFilter)localObject1).setTriggered(((TriggerCtrlItem)localObject2).isTriggered());
        ((NormalVideoFilter)this.filter).setFirstTriggered(this.triggerCtrlItem.isFirstTriggered());
        ((NormalVideoFilter)this.filter).setFrameIndex(this.triggerCtrlItem.getFrameIndex());
        ((NormalVideoFilter)this.filter).updateHotArea(this.triggerCtrlItem.getHotArea());
        ((NormalVideoFilter)this.filter).setFrameStartTime(this.triggerCtrlItem.getFrameStartTime());
        ((NormalVideoFilter)this.filter).setAudioScaleFactor((float)this.triggerCtrlItem.getAudioScaleFactor());
        ((NormalVideoFilter)this.filter).setPlayMode(this.triggerCtrlItem.getPlayMode());
        ((NormalVideoFilter)this.filter).setFirstTriggerInStateTime(this.triggerCtrlItem.getFirstTriggerInStateTime());
        ((NormalVideoFilter)this.filter).setIsInState(this.triggerCtrlItem.getInState());
        ((NormalVideoFilter)this.filter).setFirstPlaySync(this.triggerCtrlItem.getPlayFristSync());
      }
    }
    localObject1 = this.filter;
    if ((localObject1 instanceof TransformFilter))
    {
      localObject2 = this.triggerCtrlItem;
      if (localObject2 != null) {
        ((TransformFilter)localObject1).setFrameIndex(((TriggerCtrlItem)localObject2).getFrameIndex());
      }
    }
    localObject1 = this.filter;
    if ((localObject1 instanceof FabbyStrokeFilterExt))
    {
      localObject2 = this.triggerCtrlItem;
      if ((localObject2 instanceof FabbyStrokeExtTriggerCtrlItem)) {
        ((FabbyStrokeFilterExt)localObject1).updateRenderParams(((FabbyStrokeExtTriggerCtrlItem)localObject2).getModel());
      }
    }
    localObject1 = this.filter;
    if (((localObject1 instanceof FabbyFilters)) && ((this.triggerCtrlItem instanceof FabbyFiltersTriggerCtrlItem)))
    {
      int i = ((FabbyFilters)localObject1).getCurPartIndex();
      boolean bool = ((FabbyFiltersTriggerCtrlItem)this.triggerCtrlItem).isCurrentTriggered(i);
      ((FabbyFilters)this.filter).setTriggered(bool);
    }
    localObject1 = this.filter;
    if ((localObject1 instanceof VoiceTextFilter))
    {
      localObject2 = (VoiceToTextTriggerCtrlItem)this.triggerCtrlItem;
      ((VoiceTextFilter)localObject1).setRenderParticleIds(((VoiceToTextTriggerCtrlItem)localObject2).getRenderVoiceTextIds());
    }
    if ((this.filter instanceof FilamentFilter)) {
      paramObject = ((FilamentTriggerCtrlItem)this.triggerCtrlItem).getTriggerdAnimationItems();
    }
    if ((paramObject instanceof PTDetectInfo))
    {
      localObject1 = this.triggerCtrlItem;
      if (localObject1 != null)
      {
        localObject2 = (PTDetectInfo)paramObject;
        ((PTDetectInfo)localObject2).needRender = ((TriggerCtrlItem)localObject1).isTriggered();
        ((PTDetectInfo)localObject2).frameIndex = this.triggerCtrlItem.getFrameIndex();
        ((PTDetectInfo)localObject2).audioScaleFactor = this.triggerCtrlItem.getAudioScaleFactor();
        ((PTDetectInfo)localObject2).redPacketPositions = this.triggerCtrlItem.getHotArea();
      }
    }
    localObject1 = this.filter;
    if (localObject1 != null) {
      ((AEFilterI)localObject1).updatePreview(paramObject);
    }
    localObject1 = this.triggerCtrlItem;
    if ((localObject1 != null) && (!((TriggerCtrlItem)localObject1).isTriggered()))
    {
      localObject1 = this.filter;
      if ((localObject1 instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localObject1).pauseAndSeekToOrigin();
      }
      localObject1 = this.filter;
      if (((localObject1 instanceof TransformFilter)) && (((TransformFilter)localObject1).isNeedStop())) {
        ((TransformFilter)this.filter).stopTransform();
      }
      localObject1 = this.filter;
      if ((localObject1 instanceof ParticleFilter)) {
        ((ParticleFilter)localObject1).resetParams();
      }
      localObject1 = this.filter;
      if ((localObject1 instanceof ParticleFilter3D)) {
        ((ParticleFilter3D)localObject1).stopParticle3D(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.RenderItem
 * JD-Core Version:    0.7.0.1
 */