package com.tencent.mobileqq.mini.entry.search.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.search.comm.LiveInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

class SearchRecommendAdapter$LiveViewHolder$1
  implements View.OnClickListener
{
  SearchRecommendAdapter$LiveViewHolder$1(SearchRecommendAdapter.LiveViewHolder paramLiveViewHolder, LiveInfo paramLiveInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    MiniAppLauncher.startMiniApp(this.this$0.itemView.getContext(), this.val$liveInfo.mJumpUrl, 3023, null);
    paramView = new MiniAppInfo();
    paramView.appId = this.val$finalAppId;
    paramView = new MiniAppConfig(paramView);
    paramView.launchParam.scene = 3023;
    MiniProgramLpReportDC04239.reportAsync(paramView, "desktop", "search", "hot_click", this.val$liveInfo.mHotWords);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.LiveViewHolder.1
 * JD-Core Version:    0.7.0.1
 */