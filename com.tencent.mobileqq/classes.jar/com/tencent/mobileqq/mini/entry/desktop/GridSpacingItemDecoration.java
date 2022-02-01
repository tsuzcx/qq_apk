package com.tencent.mobileqq.mini.entry.desktop;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class GridSpacingItemDecoration
  extends RecyclerView.ItemDecoration
{
  private boolean includeEdge;
  private int spacing;
  private int spanCount;
  
  public GridSpacingItemDecoration(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.spanCount = paramInt1;
    this.spacing = paramInt2;
    this.includeEdge = paramBoolean;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i < 0) {}
    do
    {
      return;
      int j = paramRecyclerView.getAdapter().getItemViewType(i);
      int k = i % this.spanCount;
      if (this.includeEdge)
      {
        if (j == 2)
        {
          paramRect.bottom = this.spacing;
          return;
        }
        paramRect.bottom = 0;
        return;
      }
      paramRect.left = (this.spacing * k / this.spanCount);
      paramRect.right = (this.spacing - (k + 1) * this.spacing / this.spanCount);
    } while (i < this.spanCount);
    paramRect.top = this.spacing;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.GridSpacingItemDecoration
 * JD-Core Version:    0.7.0.1
 */