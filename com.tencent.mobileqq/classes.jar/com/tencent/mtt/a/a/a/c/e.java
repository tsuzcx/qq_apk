package com.tencent.mtt.a.a.a.c;

import androidx.recyclerview.widget.EasyRecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public final class e
{
  private final EasyRecyclerView a;
  
  public e(EasyRecyclerView paramEasyRecyclerView)
  {
    this.a = paramEasyRecyclerView;
  }
  
  public RecyclerView.ViewHolder a(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    RecyclerView.ViewHolder localViewHolder2 = this.a.findViewHolderForAdapterPosition(paramInt);
    RecyclerView.ViewHolder localViewHolder1 = localViewHolder2;
    if (localViewHolder2 == null) {
      localViewHolder1 = this.a.getViewHolderForPosition(paramInt);
    }
    return localViewHolder1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.a.a.a.c.e
 * JD-Core Version:    0.7.0.1
 */