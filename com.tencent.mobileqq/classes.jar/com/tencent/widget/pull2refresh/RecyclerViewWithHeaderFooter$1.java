package com.tencent.widget.pull2refresh;

import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

class RecyclerViewWithHeaderFooter$1
  extends RecyclerView.RecycledViewPool
{
  RecyclerViewWithHeaderFooter$1(RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter) {}
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    Object localObject = this.this$0.getAdapter();
    RecyclerView.ViewHolder localViewHolder = super.getRecycledView(paramInt);
    if ((localViewHolder != null) && ((localObject instanceof RecyclerViewHeaderViewAdapter)))
    {
      localObject = (RecyclerViewHeaderViewAdapter)localObject;
      if (((RecyclerViewHeaderViewAdapter)localObject).isFooter(paramInt))
      {
        if (!RecyclerViewWithHeaderFooter.access$000(this.this$0).contains(localViewHolder.itemView))
        {
          putRecycledView(localViewHolder);
          return null;
        }
      }
      else if ((((RecyclerViewHeaderViewAdapter)localObject).isHeader(paramInt)) && (!RecyclerViewWithHeaderFooter.access$100(this.this$0).contains(localViewHolder.itemView)))
      {
        putRecycledView(localViewHolder);
        return null;
      }
    }
    return localViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter.1
 * JD-Core Version:    0.7.0.1
 */