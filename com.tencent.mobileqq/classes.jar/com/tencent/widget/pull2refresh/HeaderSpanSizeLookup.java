package com.tencent.widget.pull2refresh;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

public class HeaderSpanSizeLookup
  extends GridLayoutManager.SpanSizeLookup
{
  private final RecyclerViewHeaderViewAdapter mAdapter;
  private GridLayoutManager.SpanSizeLookup mInnerSpanSizeLookup;
  private final GridLayoutManager mLayoutManager;
  
  public HeaderSpanSizeLookup(RecyclerViewHeaderViewAdapter paramRecyclerViewHeaderViewAdapter, GridLayoutManager paramGridLayoutManager)
  {
    this.mAdapter = paramRecyclerViewHeaderViewAdapter;
    this.mLayoutManager = paramGridLayoutManager;
  }
  
  public int getSpanSize(int paramInt)
  {
    int i;
    if ((!this.mAdapter.isHeaderPosition(paramInt)) && (!this.mAdapter.isFooterPosition(paramInt))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return this.mLayoutManager.getSpanCount();
    }
    GridLayoutManager.SpanSizeLookup localSpanSizeLookup = this.mInnerSpanSizeLookup;
    if (localSpanSizeLookup == null) {
      return 1;
    }
    return localSpanSizeLookup.getSpanSize(paramInt - this.mAdapter.getHeaderCount());
  }
  
  public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup paramSpanSizeLookup)
  {
    this.mInnerSpanSizeLookup = paramSpanSizeLookup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.HeaderSpanSizeLookup
 * JD-Core Version:    0.7.0.1
 */