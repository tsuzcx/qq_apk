package com.tencent.viola.ui.adapter;

public abstract interface VRecyclerViewAdapter$DiffItemAnimListener
{
  public abstract int getFirstVisiableItemPosition();
  
  public abstract boolean isDiffItemAnimEnable();
  
  public abstract void scrollToTop();
  
  public abstract void startDiffItemAnim();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.adapter.VRecyclerViewAdapter.DiffItemAnimListener
 * JD-Core Version:    0.7.0.1
 */