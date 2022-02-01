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
        paramView = this.val$activity;
        localObject = this.val$miniAppInfo;
        if (this.val$searchInfo.getType() == 4)
        {
          i = 3029;
          MiniAppController.launchMiniAppByAppInfo(paramView, (MiniAppInfo)localObject, i);
          paramView = new MiniAppConfig(this.val$miniAppInfo);
          paramView.launchParam.scene = 3024;
          if (this.val$searchInfo.getType() == 4) {
            paramView.launchParam.scene = 3029;
          }
          MiniProgramLpReportDC04239.reportAsync(paramView, "desktop", "search", "click", this.val$miniAppInfo.name);
          return;
        }
      }
      catch (Exception paramView)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("HotSearchAdapter, start miniApp exception: ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramView));
        QLog.e("SearchRecommendAdapter", 1, ((StringBuilder)localObject).toString());
        return;
      }
      int i = 3024;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.PlayingViewHolder.1
 * JD-Core Version:    0.7.0.1
 */