package com.tencent.qqlive.module.videoreport.page;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

class ScrollReader$RecyclerViewScrollReader
  implements IScrollReader
{
  private int[] mVisiblePos;
  
  public int readScroll(View paramView)
  {
    paramView = ((RecyclerView)paramView).getLayoutManager();
    int k;
    if ((paramView instanceof LinearLayoutManager))
    {
      k = ((LinearLayoutManager)paramView).findLastVisibleItemPosition();
      return k;
    }
    if ((paramView instanceof StaggeredGridLayoutManager))
    {
      paramView = (StaggeredGridLayoutManager)paramView;
      int m = paramView.getSpanCount();
      if ((this.mVisiblePos == null) || (this.mVisiblePos.length < m)) {
        this.mVisiblePos = new int[m];
      }
      paramView.findLastVisibleItemPositions(this.mVisiblePos);
      int i = -1;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i = Math.max(i, this.mVisiblePos[j]);
        j += 1;
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.ScrollReader.RecyclerViewScrollReader
 * JD-Core Version:    0.7.0.1
 */