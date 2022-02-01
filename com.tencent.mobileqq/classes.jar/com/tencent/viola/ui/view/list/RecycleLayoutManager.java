package com.tencent.viola.ui.view.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter;
import com.tencent.viola.ui.dom.DomObject;

public class RecycleLayoutManager
  extends StaggeredGridLayoutManager
{
  private VRecyclerViewAdapter mAdapter;
  private int mCellWidth;
  private int mColumn = 1;
  private int[] mInsetArry = new int[4];
  private int mParentWidth;
  private int mPortraitInterval;
  private RecyclerView mRecyclerView;
  private int mTransverseInterval;
  
  public RecycleLayoutManager(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  private boolean isFooterCell(int paramInt)
  {
    return "footer-cell".equals(this.mAdapter.getItem(paramInt).getType());
  }
  
  public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = this.mRecyclerView.getChildLayoutPosition(paramView);
    if (localLayoutParams.getSpanIndex() % this.mColumn == 0)
    {
      paramInt3 = this.mInsetArry[3] + 0;
      paramInt1 = this.mCellWidth + paramInt3;
    }
    int k;
    int j;
    for (;;)
    {
      k = paramView.getMeasuredHeight();
      j = this.mPortraitInterval + paramInt2;
      k += j;
      if (!isFooterCell(i)) {
        break label199;
      }
      if (i != 0) {
        break;
      }
      paramView.layout(0, paramInt2, this.mParentWidth, paramInt4);
      return;
      if (localLayoutParams.getSpanIndex() % this.mColumn == this.mColumn - 1)
      {
        paramInt1 = this.mParentWidth - this.mInsetArry[1];
        paramInt3 = paramInt1 - this.mCellWidth;
      }
      else
      {
        paramInt1 = this.mCellWidth;
        paramInt3 = this.mTransverseInterval;
        j = localLayoutParams.getSpanIndex();
        paramInt3 = this.mInsetArry[3] + j * (paramInt1 + paramInt3);
        paramInt1 = this.mCellWidth + paramInt3;
      }
    }
    paramView.layout(0, j, this.mParentWidth, k);
    return;
    label199:
    paramView.layout(paramInt3, j, paramInt1, k);
  }
  
  public void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = this.mRecyclerView.getChildLayoutPosition(paramView);
    if (localLayoutParams.getSpanIndex() % this.mColumn == 0)
    {
      paramInt3 = this.mInsetArry[3] + 0;
      paramInt1 = this.mCellWidth + paramInt3;
    }
    int k;
    int j;
    for (;;)
    {
      k = paramView.getMeasuredHeight();
      j = this.mPortraitInterval + paramInt2;
      k += j;
      if (!isFooterCell(i)) {
        break label199;
      }
      if (i != 0) {
        break;
      }
      paramView.layout(0, paramInt2, this.mParentWidth, paramInt4);
      return;
      if (localLayoutParams.getSpanIndex() % this.mColumn == this.mColumn - 1)
      {
        paramInt1 = this.mParentWidth - this.mInsetArry[1];
        paramInt3 = paramInt1 - this.mCellWidth;
      }
      else
      {
        paramInt1 = this.mCellWidth;
        paramInt3 = this.mTransverseInterval;
        j = localLayoutParams.getSpanIndex();
        paramInt3 = this.mInsetArry[3] + j * (paramInt1 + paramInt3);
        paramInt1 = this.mCellWidth + paramInt3;
      }
    }
    paramView.layout(0, j, this.mParentWidth, k);
    return;
    label199:
    paramView.layout(paramInt3, j, paramInt1, k);
  }
  
  public void setAdapter(VRecyclerViewAdapter paramVRecyclerViewAdapter)
  {
    this.mAdapter = paramVRecyclerViewAdapter;
  }
  
  public void setCellWidth(int paramInt)
  {
    this.mCellWidth = paramInt;
  }
  
  public void setColumn(int paramInt)
  {
    this.mColumn = paramInt;
  }
  
  public void setInsetArry(int[] paramArrayOfInt)
  {
    this.mInsetArry = paramArrayOfInt;
  }
  
  public void setItemPortraitInterval(int paramInt)
  {
    this.mPortraitInterval = paramInt;
  }
  
  public void setItemTransverseInterval(int paramInt)
  {
    this.mTransverseInterval = paramInt;
  }
  
  public void setParentWidth(float paramFloat)
  {
    this.mParentWidth = ((int)paramFloat);
  }
  
  public void setRecycleView(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.RecycleLayoutManager
 * JD-Core Version:    0.7.0.1
 */