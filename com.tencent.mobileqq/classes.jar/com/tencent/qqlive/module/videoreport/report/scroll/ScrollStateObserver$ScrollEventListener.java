package com.tencent.qqlive.module.videoreport.report.scroll;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

class ScrollStateObserver$ScrollEventListener
  extends DefaultEventListener
{
  private ScrollStateObserver$ScrollEventListener(ScrollStateObserver paramScrollStateObserver) {}
  
  public void onListScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ScrollStateObserver", "onListScrollStateChanged: scrollState=" + paramInt);
    }
    this.this$0.onScrollStateChanged(paramAbsListView, paramInt);
  }
  
  public void onSetRecyclerViewAdapter(RecyclerView paramRecyclerView)
  {
    this.this$0.inject(paramRecyclerView);
  }
  
  public void onSetViewPagerAdapter(ViewPager paramViewPager)
  {
    this.this$0.inject(paramViewPager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollStateObserver.ScrollEventListener
 * JD-Core Version:    0.7.0.1
 */