package com.tencent.viola.ui.view.list;

import android.support.v7.widget.RecyclerView.ViewHolder;

public abstract interface PagerSnapHelper$PagerEventListener
{
  public abstract void onFooterRebound();
  
  public abstract void onPagerChanged(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void onPagerRebound(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper.PagerEventListener
 * JD-Core Version:    0.7.0.1
 */