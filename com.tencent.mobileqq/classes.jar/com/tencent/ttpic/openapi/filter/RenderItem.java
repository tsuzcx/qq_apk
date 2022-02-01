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
    if (this.filter == null) {}
    while ((this.triggerCtrlItem != null) && (!this.triggerCtrlItem.isTriggered())) {
      return paramFrame;
    }
    return this.filter.RenderProcess(paramFrame);
  }
  
  public void apply() {}
  
  public void clear() {}
  
  public void updatePreview(Object paramObject)
  {
    if (((this.filter instanceof NormalVideoFilter)) && (this.triggerCtrlItem != null))
    {
      ((NormalVideoFilter)this.filter).setTriggered(this.triggerCtrlItem.isTriggered());
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
    if (((this.filter instanceof TransformFilter)) && (this.triggerCtrlItem != null)) {
      ((TransformFilter)this.filter).setFrameIndex(this.triggerCtrlItem.getFrameIndex());
    }
    if (((this.filter instanceof FabbyStrokeFilterExt)) && ((this.triggerCtrlItem instanceof FabbyStrokeExtTriggerCtrlItem))) {
      ((FabbyStrokeFilterExt)this.filter).updateRenderParams(((FabbyStrokeExtTriggerCtrlItem)this.triggerCtrlItem).getModel());
    }
    if (((this.filter instanceof FabbyFilters)) && ((this.triggerCtrlItem instanceof FabbyFiltersTriggerCtrlItem)))
    {
      int i = ((FabbyFilters)this.filter).getCurPartIndex();
      boolean bool = ((FabbyFiltersTriggerCtrlItem)this.triggerCtrlItem).isCurrentTriggered(i);
      ((FabbyFilters)this.filter).setTriggered(bool);
    }
    if ((this.filter instanceof VoiceTextFilter))
    {
      VoiceToTextTriggerCtrlItem localVoiceToTextTriggerCtrlItem = (VoiceToTextTriggerCtrlItem)this.triggerCtrlItem;
      ((VoiceTextFilter)this.filter).setRenderParticleIds(localVoiceToTextTriggerCtrlItem.getRenderVoiceTextIds());
    }
    if ((this.filter instanceof FilamentFilter)) {
      paramObject = ((FilamentTriggerCtrlItem)this.triggerCtrlItem).getTriggerdAnimationItems();
    }
    for (;;)
    {
      if (((paramObject instanceof PTDetectInfo)) && (this.triggerCtrlItem != null))
      {
        ((PTDetectInfo)paramObject).needRender = this.triggerCtrlItem.isTriggered();
        ((PTDetectInfo)paramObject).frameIndex = this.triggerCtrlItem.getFrameIndex();
        ((PTDetectInfo)paramObject).audioScaleFactor = this.triggerCtrlItem.getAudioScaleFactor();
        ((PTDetectInfo)paramObject).redPacketPositions = this.triggerCtrlItem.getHotArea();
      }
      if (this.filter != null) {
        this.filter.updatePreview(paramObject);
      }
      if ((this.triggerCtrlItem != null) && (!this.triggerCtrlItem.isTriggered()))
      {
        if ((this.filter instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)this.filter).pauseAndSeekToOrigin();
        }
        if (((this.filter instanceof TransformFilter)) && (((TransformFilter)this.filter).isNeedStop())) {
          ((TransformFilter)this.filter).stopTransform();
        }
        if ((this.filter instanceof ParticleFilter)) {
          ((ParticleFilter)this.filter).resetParams();
        }
        if ((this.filter instanceof ParticleFilter3D)) {
          ((ParticleFilter3D)this.filter).stopParticle3D(paramObject);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.RenderItem
 * JD-Core Version:    0.7.0.1
 */