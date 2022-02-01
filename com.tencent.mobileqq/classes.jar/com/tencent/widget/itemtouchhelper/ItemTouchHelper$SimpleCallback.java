package com.tencent.widget.itemtouchhelper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

public abstract class ItemTouchHelper$SimpleCallback
  extends ItemTouchHelper.Callback
{
  private int mDefaultDragDirs;
  private int mDefaultSwipeDirs;
  
  public ItemTouchHelper$SimpleCallback(int paramInt1, int paramInt2)
  {
    this.mDefaultSwipeDirs = paramInt2;
    this.mDefaultDragDirs = paramInt1;
  }
  
  public int getDragDirs(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return this.mDefaultDragDirs;
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return makeMovementFlags(getDragDirs(paramRecyclerView, paramViewHolder), getSwipeDirs(paramRecyclerView, paramViewHolder));
  }
  
  public int getSwipeDirs(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return this.mDefaultSwipeDirs;
  }
  
  public void setDefaultDragDirs(int paramInt)
  {
    this.mDefaultDragDirs = paramInt;
  }
  
  public void setDefaultSwipeDirs(int paramInt)
  {
    this.mDefaultSwipeDirs = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.SimpleCallback
 * JD-Core Version:    0.7.0.1
 */