package com.tencent.viola.ui.view.list;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter;
import com.tencent.viola.ui.dom.DomObject;

public class RecycleViewItemDecoration
  extends RecyclerView.ItemDecoration
{
  private VRecyclerViewAdapter mAdapter;
  private int mColumn = 1;
  private int mPortraitInterval;
  private int mTransverseInterval;
  
  private boolean isFooterCell(int paramInt)
  {
    return "footer-cell".equals(this.mAdapter.getItem(paramInt).getType());
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    paramRect.left = (this.mTransverseInterval / 2);
    paramRect.top = this.mPortraitInterval;
    paramRect.right = (this.mTransverseInterval / 2);
    if ((paramView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams))
    {
      paramView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      if (paramView.getSpanIndex() % this.mColumn != 0) {
        break label95;
      }
      paramRect.left = 0;
    }
    while (isFooterCell(i))
    {
      if (i == 0) {
        paramRect.top = 0;
      }
      paramView.setFullSpan(true);
      return;
      label95:
      if (paramView.getSpanIndex() % this.mColumn == this.mColumn - 1) {
        paramRect.right = 0;
      }
    }
    paramView.setFullSpan(false);
  }
  
  public void setAdapter(VRecyclerViewAdapter paramVRecyclerViewAdapter)
  {
    this.mAdapter = paramVRecyclerViewAdapter;
  }
  
  public void setColumn(int paramInt)
  {
    this.mColumn = paramInt;
  }
  
  public void setItemPortraitInterval(int paramInt)
  {
    this.mPortraitInterval = paramInt;
  }
  
  public void setItemTransverseInterval(int paramInt)
  {
    this.mTransverseInterval = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.RecycleViewItemDecoration
 * JD-Core Version:    0.7.0.1
 */