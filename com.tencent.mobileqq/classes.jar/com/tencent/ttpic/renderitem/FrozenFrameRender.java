package com.tencent.ttpic.renderitem;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.filter.FrozenFrameFilter;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.trigger.triggerctrlitem.FrozenFrameTrigerCtrlItem;

public class FrozenFrameRender
  extends RenderItem
{
  public FrozenFrameRender(FrozenFrameFilter paramFrozenFrameFilter, FrozenFrameTrigerCtrlItem paramFrozenFrameTrigerCtrlItem)
  {
    super(paramFrozenFrameFilter, paramFrozenFrameTrigerCtrlItem);
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return updateInputFrame(paramFrame, null);
  }
  
  public void clear()
  {
    if (this.triggerCtrlItem != null) {
      ((FrozenFrameTrigerCtrlItem)this.triggerCtrlItem).clear();
    }
  }
  
  public PTFaceAttr getPTFaceSnapshot()
  {
    if ((this.triggerCtrlItem != null) && (this.triggerCtrlItem.isTriggered())) {
      return ((FrozenFrameTrigerCtrlItem)this.triggerCtrlItem).getPTFaceSnapshot();
    }
    return null;
  }
  
  public boolean isFreeze()
  {
    return (this.triggerCtrlItem != null) && (this.triggerCtrlItem.isTriggered());
  }
  
  public void setAllFrameFreeze(boolean paramBoolean)
  {
    FrozenFrameTrigerCtrlItem localFrozenFrameTrigerCtrlItem;
    if (this.triggerCtrlItem != null)
    {
      localFrozenFrameTrigerCtrlItem = (FrozenFrameTrigerCtrlItem)this.triggerCtrlItem;
      if (paramBoolean) {
        localFrozenFrameTrigerCtrlItem.addAllFreezeTrigger();
      }
    }
    else
    {
      return;
    }
    localFrozenFrameTrigerCtrlItem.removeAllFreezeTrigger();
  }
  
  public void updateGestureTrigger(AIAttr paramAIAttr)
  {
    if ((this.triggerCtrlItem != null) && (this.triggerCtrlItem.isTriggered())) {
      ((FrozenFrameTrigerCtrlItem)this.triggerCtrlItem).updateGestuereTrigger(paramAIAttr);
    }
  }
  
  public Frame updateInputFrame(Frame paramFrame1, Frame paramFrame2, BaseFilter paramBaseFilter)
  {
    if ((this.triggerCtrlItem == null) || (!this.triggerCtrlItem.isTriggered())) {
      return paramFrame1;
    }
    return ((FrozenFrameTrigerCtrlItem)this.triggerCtrlItem).updateInputFrame(paramFrame1, paramFrame2, paramBaseFilter);
  }
  
  public Frame updateInputFrame(Frame paramFrame, BaseFilter paramBaseFilter)
  {
    if ((this.triggerCtrlItem == null) || (!this.triggerCtrlItem.isTriggered())) {
      return paramFrame;
    }
    return ((FrozenFrameTrigerCtrlItem)this.triggerCtrlItem).updateInputFrame(paramFrame, paramBaseFilter);
  }
  
  public PTFaceAttr updatePTFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    if ((this.triggerCtrlItem == null) || (!this.triggerCtrlItem.isTriggered())) {
      return paramPTFaceAttr;
    }
    return ((FrozenFrameTrigerCtrlItem)this.triggerCtrlItem).updateFaceAttr(paramPTFaceAttr);
  }
  
  public PTSegAttr updatePTSegAttr(PTSegAttr paramPTSegAttr, BaseFilter paramBaseFilter)
  {
    if ((this.triggerCtrlItem == null) || (!this.triggerCtrlItem.isTriggered())) {
      return paramPTSegAttr;
    }
    return ((FrozenFrameTrigerCtrlItem)this.triggerCtrlItem).updatePTSegAttr(paramPTSegAttr, paramBaseFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.renderitem.FrozenFrameRender
 * JD-Core Version:    0.7.0.1
 */