package com.tencent.qqlive.module.videoreport.report.scroll;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.page.PageSwitchObserver;

class ScrollableViewManager$ScrollStateHelper
  extends ScrollStateObserver
{
  boolean observerChildAttachState(View paramView)
  {
    return ScrollableViewExposureReport.isScrollExposureEnable(paramView);
  }
  
  void onChildViewAttached(View paramView)
  {
    ScrollableViewExposureReport.getInstance().onChildViewAttached(paramView);
  }
  
  void onChildViewDetached(View paramView)
  {
    ScrollableViewExposureReport.getInstance().onChildViewDetached(paramView);
  }
  
  void onScrollViewStateChanged(View paramView, int paramInt)
  {
    if (((paramView instanceof AbsListView)) || ((paramView instanceof RecyclerView))) {
      ScrollableViewExposureReport.getInstance().onScrollStateChanged(paramView, paramInt);
    }
    if (paramInt == 0) {
      PageSwitchObserver.getInstance().onPageViewVisible(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewManager.ScrollStateHelper
 * JD-Core Version:    0.7.0.1
 */