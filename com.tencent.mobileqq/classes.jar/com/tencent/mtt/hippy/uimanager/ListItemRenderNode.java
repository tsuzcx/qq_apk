package com.tencent.mtt.hippy.uimanager;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.list.IRecycleItemTypeChange;

public class ListItemRenderNode
  extends RenderNode
{
  private boolean a;
  private IRecycleItemTypeChange b;
  
  public ListItemRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    super(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
    if (this.mProps.get("sticky") != null) {
      this.a = this.mProps.getBoolean("sticky");
    }
  }
  
  public void a(IRecycleItemTypeChange paramIRecycleItemTypeChange)
  {
    this.b = paramIRecycleItemTypeChange;
  }
  
  public boolean shouldSticky()
  {
    return this.a;
  }
  
  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.updateLayout(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mY = 0;
    if ((getParent() != null) && (this.mComponentManager != null) && (this.mComponentManager.a != null))
    {
      RenderManager localRenderManager = this.mComponentManager.a.getRenderManager();
      if (localRenderManager != null) {
        localRenderManager.addUpdateNodeIfNeeded(getParent());
      }
    }
  }
  
  public void updateNode(HippyMap paramHippyMap)
  {
    int i = this.mProps.getInt("itemViewType");
    int j = paramHippyMap.getInt("itemViewType");
    if ((this.b != null) && (i != j)) {
      this.b.onRecycleItemTypeChanged(i, j, this);
    }
    super.updateNode(paramHippyMap);
    if (this.mProps.get("sticky") != null) {
      this.a = this.mProps.getBoolean("sticky");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.ListItemRenderNode
 * JD-Core Version:    0.7.0.1
 */