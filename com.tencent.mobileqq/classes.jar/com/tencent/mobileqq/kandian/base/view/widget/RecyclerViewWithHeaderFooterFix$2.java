package com.tencent.mobileqq.kandian.base.view.widget;

import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import java.util.List;

class RecyclerViewWithHeaderFooterFix$2
  extends RecyclerView.RecycledViewPool
{
  RecyclerViewWithHeaderFooterFix$2(RecyclerViewWithHeaderFooterFix paramRecyclerViewWithHeaderFooterFix) {}
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    Object localObject = this.a.getAdapter();
    RecyclerView.ViewHolder localViewHolder = super.getRecycledView(paramInt);
    if ((localViewHolder != null) && ((localObject instanceof RecyclerViewHeaderViewAdapter)))
    {
      localObject = (RecyclerViewHeaderViewAdapter)localObject;
      if (((RecyclerViewHeaderViewAdapter)localObject).isFooter(paramInt))
      {
        if (!RecyclerViewWithHeaderFooterFix.a(this.a).contains(localViewHolder.itemView))
        {
          putRecycledView(localViewHolder);
          return null;
        }
      }
      else if ((((RecyclerViewHeaderViewAdapter)localObject).isHeader(paramInt)) && (!RecyclerViewWithHeaderFooterFix.b(this.a).contains(localViewHolder.itemView)))
      {
        putRecycledView(localViewHolder);
        return null;
      }
    }
    return localViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RecyclerViewWithHeaderFooterFix.2
 * JD-Core Version:    0.7.0.1
 */