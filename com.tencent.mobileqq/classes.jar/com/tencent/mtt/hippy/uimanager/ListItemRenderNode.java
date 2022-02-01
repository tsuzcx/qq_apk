package com.tencent.mtt.hippy.uimanager;

import android.view.View;
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
  
  private int a(HippyMap paramHippyMap)
  {
    int j = paramHippyMap.getInt("type");
    int i = j;
    if (j <= 0)
    {
      i = j;
      if (paramHippyMap.getString("type") == null) {}
    }
    try
    {
      i = Integer.parseInt(paramHippyMap.getString("type"));
      j = i;
      if (i <= 0) {
        j = paramHippyMap.getInt("itemViewType");
      }
      return j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public int a()
  {
    return a(this.mProps);
  }
  
  public void a(IRecycleItemTypeChange paramIRecycleItemTypeChange)
  {
    this.b = paramIRecycleItemTypeChange;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    boolean bool3 = this.mComponentManager.a(this.mId);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.mComponentManager.b(this.mRootView, this.mId, this.mClassName, this.mProps).getParent() == null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean e()
  {
    return this.mComponentManager.a(this.mId);
  }
  
  public boolean f()
  {
    return this.mRootView != null;
  }
  
  public int indexFromParent()
  {
    return super.indexFromParent();
  }
  
  public boolean shouldSticky()
  {
    return this.a;
  }
  
  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.updateLayout(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.mComponentManager.b.a(this.mId);
    if (localObject != null) {
      paramInt1 = ((View)localObject).getTop();
    } else {
      paramInt1 = 0;
    }
    this.mY = paramInt1;
    if ((getParent() != null) && (this.mComponentManager != null) && (this.mComponentManager.a != null))
    {
      localObject = this.mComponentManager.a.getRenderManager();
      if (localObject != null) {
        ((RenderManager)localObject).addUpdateNodeIfNeeded(getParent());
      }
    }
  }
  
  public void updateNode(HippyMap paramHippyMap)
  {
    int i = a(this.mProps);
    int j = a(paramHippyMap);
    IRecycleItemTypeChange localIRecycleItemTypeChange = this.b;
    if ((localIRecycleItemTypeChange != null) && (i != j)) {
      localIRecycleItemTypeChange.onRecycleItemTypeChanged(i, j, this);
    }
    super.updateNode(paramHippyMap);
    if (this.mProps.get("sticky") != null) {
      this.a = this.mProps.getBoolean("sticky");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.ListItemRenderNode
 * JD-Core Version:    0.7.0.1
 */