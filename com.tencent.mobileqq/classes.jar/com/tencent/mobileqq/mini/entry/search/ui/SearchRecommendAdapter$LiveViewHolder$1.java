package com.tencent.mobileqq.mini.entry.search.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.entry.search.comm.LiveInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchRecommendAdapter$LiveViewHolder$1
  implements View.OnClickListener
{
  SearchRecommendAdapter$LiveViewHolder$1(SearchRecommendAdapter.LiveViewHolder paramLiveViewHolder, LiveInfo paramLiveInfo) {}
  
  public void onClick(View paramView)
  {
    MiniAppLauncher.startMiniApp(this.this$0.itemView.getContext(), this.val$liveInfo.mJumpUrl, 3017, null);
    MiniProgramLpReportDC04239.reportAsync("desktop", "search", "hot_click", this.val$liveInfo.mHotWords);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.LiveViewHolder.1
 * JD-Core Version:    0.7.0.1
 */