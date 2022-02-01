package com.tencent.qqlive.module.videoreport.page;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

final class ScrollReader$1
  extends RecyclerView.OnScrollListener
{
  ScrollReader$1(ScrollReader.OnScrollChangeListener paramOnScrollChangeListener) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      this.val$listener.onScrollChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.ScrollReader.1
 * JD-Core Version:    0.7.0.1
 */