package com.tencent.mobileqq.mini.entry.search.ui;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class MiniAppSearchFragment$1
  extends GridLayoutManager.SpanSizeLookup
{
  MiniAppSearchFragment$1(MiniAppSearchFragment paramMiniAppSearchFragment) {}
  
  public int getSpanSize(int paramInt)
  {
    int i = 1;
    if (MiniAppSearchFragment.access$000(this.this$0).getItemViewType(paramInt) == 1) {
      i = 2;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */