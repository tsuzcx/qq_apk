package com.tencent.widget.pull2refresh;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public abstract interface IViewHolderItemDecoration
{
  public abstract int getColor();
  
  public abstract void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.IViewHolderItemDecoration
 * JD-Core Version:    0.7.0.1
 */