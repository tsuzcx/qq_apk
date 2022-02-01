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
    if (i < 0) {
      return;
    }
    int m = paramRecyclerView.getAdapter().getItemViewType(i);
    int j = this.spanCount;
    int k = i % j;
    if (this.includeEdge)
    {
      if (m == 2)
      {
        paramRect.bottom = this.spacing;
        return;
      }
      paramRect.bottom = 0;
      return;
    }
    m = this.spacing;
    paramRect.left = (k * m / j);
    paramRect.right = (m - (k + 1) * m / j);
    if (i >= j) {
      paramRect.top = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.GridSpacingItemDecoration
 * JD-Core Version:    0.7.0.1
 */