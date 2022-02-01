package com.tencent.mobileqq.vas.hippy.view.waterfall;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;

public class HippyWaterfallViewNode
  extends RenderNode
{
  public HippyWaterfallViewNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    super(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  protected void addChildToPendingList(RenderNode paramRenderNode) {}
  
  public void remove(int paramInt)
  {
    super.remove(paramInt);
  }
  
  public boolean removeChild(RenderNode paramRenderNode)
  {
    if ((paramRenderNode instanceof HippyWaterfallItemRenderNode)) {
      ((HippyWaterfallItemRenderNode)paramRenderNode).a(null);
    }
    return super.removeChild(paramRenderNode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallViewNode
 * JD-Core Version:    0.7.0.1
 */