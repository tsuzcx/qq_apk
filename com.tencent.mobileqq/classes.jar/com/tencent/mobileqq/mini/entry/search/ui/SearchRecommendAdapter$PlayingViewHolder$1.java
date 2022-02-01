package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchRecommendAdapter$PlayingViewHolder$1
  implements View.OnClickListener
{
  SearchRecommendAdapter$PlayingViewHolder$1(SearchRecommendAdapter.PlayingViewHolder paramPlayingViewHolder, Activity paramActivity, MiniAppInfo paramMiniAppInfo, SearchInfo paramSearchInfo) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        Object localObject = this.val$activity;
        MiniAppInfo localMiniAppInfo = this.val$miniAppInfo;
        if (this.val$searchInfo.getType() != 4) {
          continue;
        }
        i = 3029;
        MiniAppController.launchMiniAppByAppInfo((Activity)localObject, localMiniAppInfo, i);
        localObject = new MiniAppConfig(this.val$miniAppInfo);
        ((MiniAppConfig)localObject).launchParam.scene = 3024;
        if (this.val$searchInfo.getType() == 4) {
          ((MiniAppConfig)localObject).launchParam.scene = 3029;
        }
        MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, "desktop", "search", "click", this.val$miniAppInfo.name);
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("SearchRecommendAdapter", 1, "HotSearchAdapter, start miniApp exception: " + Log.getStackTraceString(localException));
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 3024;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.PlayingViewHolder.1
 * JD-Core Version:    0.7.0.1
 */