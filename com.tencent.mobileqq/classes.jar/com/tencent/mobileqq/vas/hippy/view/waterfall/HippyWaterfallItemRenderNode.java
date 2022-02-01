package com.tencent.mobileqq.vas.hippy.view.waterfall;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import org.jetbrains.annotations.NotNull;

public class HippyWaterfallItemRenderNode
  extends RenderNode
{
  HippyWaterfallItemRenderNode.IRecycleItemTypeChange a;
  
  public HippyWaterfallItemRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    super(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  public int a()
  {
    HippyMap localHippyMap = getProps();
    if ((localHippyMap != null) && (localHippyMap.containsKey("type"))) {
      return localHippyMap.getInt("type");
    }
    return -1;
  }
  
  public void a(HippyWaterfallItemRenderNode.IRecycleItemTypeChange paramIRecycleItemTypeChange)
  {
    this.a = paramIRecycleItemTypeChange;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[type:");
    localStringBuilder.append(a());
    localStringBuilder.append("]");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
  
  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.updateLayout(paramInt1, 0, paramInt3, paramInt4);
  }
  
  public void updateNode(HippyMap paramHippyMap)
  {
    int i = getProps().getInt("type");
    int j = paramHippyMap.getInt("type");
    HippyWaterfallItemRenderNode.IRecycleItemTypeChange localIRecycleItemTypeChange = this.a;
    if ((localIRecycleItemTypeChange != null) && (i != j)) {
      localIRecycleItemTypeChange.a(i, j, this);
    }
    super.updateNode(paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallItemRenderNode
 * JD-Core Version:    0.7.0.1
 */