package com.tencent.mtt.hippy.views.hippylist;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;

public class HippyRecyclerViewHolder
  extends RecyclerView.ViewHolder
{
  public ListItemRenderNode bindNode;
  
  public HippyRecyclerViewHolder(@NonNull View paramView, ListItemRenderNode paramListItemRenderNode)
  {
    super(paramView);
    this.bindNode = paramListItemRenderNode;
  }
  
  public boolean isRenderDeleted()
  {
    ListItemRenderNode localListItemRenderNode = this.bindNode;
    if (localListItemRenderNode != null) {
      return localListItemRenderNode.isDelete();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewHolder
 * JD-Core Version:    0.7.0.1
 */