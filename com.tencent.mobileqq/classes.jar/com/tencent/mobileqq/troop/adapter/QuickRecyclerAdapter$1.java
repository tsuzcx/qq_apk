package com.tencent.mobileqq.troop.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class QuickRecyclerAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  QuickRecyclerAdapter$1(QuickRecyclerAdapter paramQuickRecyclerAdapter, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((!this.b.b(paramInt)) && (!this.b.c(paramInt)) && (!this.b.d(paramInt)) && (!this.b.e())) {
      return 1;
    }
    return this.a.getSpanCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter.1
 * JD-Core Version:    0.7.0.1
 */