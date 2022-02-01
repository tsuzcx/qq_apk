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
    if ((paramView instanceof LinearLayoutManager)) {
      return ((LinearLayoutManager)paramView).findLastVisibleItemPosition();
    }
    boolean bool = paramView instanceof StaggeredGridLayoutManager;
    int i = -1;
    int k = i;
    if (bool)
    {
      paramView = (StaggeredGridLayoutManager)paramView;
      int m = paramView.getSpanCount();
      int[] arrayOfInt = this.mVisiblePos;
      if ((arrayOfInt == null) || (arrayOfInt.length < m)) {
        this.mVisiblePos = new int[m];
      }
      paramView.findLastVisibleItemPositions(this.mVisiblePos);
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
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.ScrollReader.RecyclerViewScrollReader
 * JD-Core Version:    0.7.0.1
 */