package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;

class SearchResultAdapter$SearchResultViewHolder$1
  implements View.OnClickListener
{
  SearchResultAdapter$SearchResultViewHolder$1(SearchResultAdapter.SearchResultViewHolder paramSearchResultViewHolder, Activity paramActivity, MiniAppInfo paramMiniAppInfo, SearchInfo paramSearchInfo, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        paramView = this.val$activity;
        localObject = this.val$miniAppInfo;
        if (this.val$searchInfo.getType() == 5)
        {
          i = 3028;
          MiniAppController.launchMiniAppByAppInfo(paramView, (MiniAppInfo)localObject, i);
          ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).updateHistorySearchList(this.val$keyword);
          paramView = new MiniAppConfig(this.val$miniAppInfo);
          paramView.launchParam.scene = 3026;
          if (this.val$searchInfo.getType() == 5) {
            paramView.launchParam.scene = 3028;
          }
          MiniProgramLpReportDC04239.reportAsync(paramView, "desktop", "search", this.val$reserves_click, this.val$keyword);
          return;
        }
      }
      catch (Exception paramView)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SearchResultAdapter, start miniApp exception: ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramView));
        QLog.e("SearchResultAdapter", 1, ((StringBuilder)localObject).toString());
        return;
      }
      int i = 3026;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.SearchResultViewHolder.1
 * JD-Core Version:    0.7.0.1
 */