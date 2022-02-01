package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;

public abstract interface RecyclerAdapter$RecyclerViewItemListener
{
  public abstract void onCheckedChanged(View paramView, int paramInt, boolean paramBoolean);
  
  public abstract void onItemClick(View paramView, int paramInt, ContentHolder paramContentHolder);
  
  public abstract void onItemClickInEditMode(View paramView, int paramInt, ContentHolder paramContentHolder);
  
  public abstract boolean onItemLongClick(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter.RecyclerViewItemListener
 * JD-Core Version:    0.7.0.1
 */