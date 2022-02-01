package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchRecommendAdapter$PlayingViewHolder$1
  implements View.OnClickListener
{
  SearchRecommendAdapter$PlayingViewHolder$1(SearchRecommendAdapter.PlayingViewHolder paramPlayingViewHolder, Activity paramActivity, MiniAppInfo paramMiniAppInfo) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      MiniAppController.launchMiniAppByAppInfo(this.val$activity, this.val$miniAppInfo, 3024);
      MiniAppConfig localMiniAppConfig = new MiniAppConfig(this.val$miniAppInfo);
      localMiniAppConfig.launchParam.scene = 3024;
      MiniProgramLpReportDC04239.reportAsync(localMiniAppConfig, "desktop", "search", "click", this.val$miniAppInfo.name);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("SearchRecommendAdapter", 1, "HotSearchAdapter, start miniApp exception: " + Log.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.PlayingViewHolder.1
 * JD-Core Version:    0.7.0.1
 */