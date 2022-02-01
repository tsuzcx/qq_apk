package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public abstract class ItemTouchHelper$SimpleCallback
  extends ItemTouchHelper.Callback
{
  private int a;
  private int b;
  
  public ItemTouchHelper$SimpleCallback(int paramInt1, int paramInt2)
  {
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return b(f(paramRecyclerView, paramViewHolder), e(paramRecyclerView, paramViewHolder));
  }
  
  public int e(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return this.a;
  }
  
  public int f(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.SimpleCallback
 * JD-Core Version:    0.7.0.1
 */