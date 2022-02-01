package com.tencent.ttpic.renderitem;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.ttpic.openapi.filter.RenderOrderItem;
import com.tencent.ttpic.openapi.filter.stylizefilter.BSmoothFilter;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.trigger.triggerctrlitem.StyleFilterTriggerCtrlItem;

public class StyleFilterRender
  extends RenderOrderItem
{
  private BSmoothFilter mBilaterialFitler;
  
  public StyleFilterRender(AEFilterI paramAEFilterI, TriggerCtrlItem paramTriggerCtrlItem)
  {
    super(paramAEFilterI, paramTriggerCtrlItem);
  }
  
  public StyleFilterRender(AEFilterI paramAEFilterI, TriggerCtrlItem paramTriggerCtrlItem, int paramInt)
  {
    super(paramAEFilterI, paramTriggerCtrlItem, paramInt);
  }
  
  private Frame renderBilaterialFitler(Frame paramFrame)
  {
    if (this.mBilaterialFitler == null)
    {
      this.mBilaterialFitler = new BSmoothFilter();
      this.mBilaterialFitler.initial();
      this.mBilaterialFitler.updateSmoothOpacity(0.8F);
    }
    Frame localFrame = FrameBufferCache.getInstance().get(paramFrame.width, paramFrame.height);
    this.mBilaterialFitler.updateAndRender(paramFrame, localFrame);
    if (localFrame != paramFrame) {
      paramFrame.unlock();
    }
    return localFrame;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    if ((this.filter == null) || ((this.mCurrentOrder != 0) && (this.mCurrentOrder != this.RENDER_OREDER))) {}
    while ((this.triggerCtrlItem != null) && (!this.triggerCtrlItem.isTriggered())) {
      return paramFrame;
    }
    Frame localFrame = paramFrame;
    if (this.triggerCtrlItem != null)
    {
      localFrame = paramFrame;
      if ((this.triggerCtrlItem instanceof StyleFilterTriggerCtrlItem))
      {
        localFrame = paramFrame;
        if (((StyleFilterTriggerCtrlItem)this.triggerCtrlItem).isDenoise()) {
          localFrame = renderBilaterialFitler(paramFrame);
        }
      }
    }
    paramFrame = this.filter.RenderProcess(localFrame);
    if (localFrame != paramFrame) {
      localFrame.unlock();
    }
    return paramFrame;
  }
  
  public void apply()
  {
    if ((this.filter != null) && ((this.filter instanceof AEChainI)))
    {
      AEChainI localAEChainI = (AEChainI)this.filter;
      if (!localAEChainI.isApplied()) {
        localAEChainI.applyChain();
      }
    }
  }
  
  public void clear()
  {
    if (this.mBilaterialFitler != null) {
      this.mBilaterialFitler.clear();
    }
    if (this.triggerCtrlItem != null) {
      this.triggerCtrlItem.clear();
    }
    if (this.filter == null) {}
    while (!(this.filter instanceof AEChainI)) {
      return;
    }
    ((AEChainI)this.filter).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.renderitem.StyleFilterRender
 * JD-Core Version:    0.7.0.1
 */