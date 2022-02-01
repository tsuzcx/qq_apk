package com.tencent.qqlive.module.videoreport.page;

import android.view.View;
import android.widget.AbsListView;

class ScrollReader$AbsListViewScrollReader
  implements IScrollReader
{
  public int readScroll(View paramView)
  {
    return ((AbsListView)paramView).getLastVisiblePosition();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.ScrollReader.AbsListViewScrollReader
 * JD-Core Version:    0.7.0.1
 */