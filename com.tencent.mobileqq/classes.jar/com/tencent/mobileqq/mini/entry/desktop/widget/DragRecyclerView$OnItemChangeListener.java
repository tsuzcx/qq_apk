package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.support.v7.widget.RecyclerView.ViewHolder;

public abstract interface DragRecyclerView$OnItemChangeListener
{
  public abstract boolean isItemDeleteable(int paramInt);
  
  public abstract boolean isItemDragable(int paramInt);
  
  public abstract boolean isItemDropable(int paramInt);
  
  public abstract boolean isMoveToDeleteArea(int paramInt1, int paramInt2);
  
  public abstract void onDragFinish(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public abstract void onDragMove(int paramInt1, int paramInt2);
  
  public abstract void onDragStart(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public abstract void onItemDelete(int paramInt);
  
  public abstract void onItemDraw(RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2);
  
  public abstract void onItemMoved(int paramInt1, int paramInt2);
  
  public abstract void onItemPrepared(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.OnItemChangeListener
 * JD-Core Version:    0.7.0.1
 */