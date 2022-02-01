package com.tencent.mtt.hippy.uimanager;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;

public class e
  extends RenderNode
{
  public e(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    super(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  protected void addChildToPendingList(RenderNode paramRenderNode) {}
  
  public boolean removeChild(RenderNode paramRenderNode)
  {
    if ((paramRenderNode instanceof ListItemRenderNode)) {
      ((ListItemRenderNode)paramRenderNode).a(null);
    }
    return super.removeChild(paramRenderNode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.e
 * JD-Core Version:    0.7.0.1
 */