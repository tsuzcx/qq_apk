package com.tencent.widget.pull2refresh;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class AdapterItemDecoration
  extends RecyclerView.ItemDecoration
{
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if ((paramRecyclerView.getChildViewHolder(paramView) instanceof IViewHolderItemDecoration)) {
      ((IViewHolderItemDecoration)paramRecyclerView.getChildViewHolder(paramView)).a(paramRect, paramView, paramRecyclerView, paramState);
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.AdapterItemDecoration
 * JD-Core Version:    0.7.0.1
 */