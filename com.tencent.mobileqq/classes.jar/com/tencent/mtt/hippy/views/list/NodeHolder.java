package com.tencent.mtt.hippy.views.list;

import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.supportui.views.recyclerview.ContentHolder;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;

public class NodeHolder
  extends ContentHolder
{
  public boolean isCreated = true;
  public RenderNode mBindNode;
  
  public void inTraversals(int paramInt1, int paramInt2, RecyclerViewBase paramRecyclerViewBase)
  {
    super.inTraversals(paramInt1, paramInt2, paramRecyclerViewBase);
    if ((paramRecyclerViewBase instanceof RecyclerViewBase)) {
      paramRecyclerViewBase.handleInTraversal(paramInt1, paramInt2, this.mContentView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.list.NodeHolder
 * JD-Core Version:    0.7.0.1
 */