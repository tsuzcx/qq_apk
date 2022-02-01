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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;

class SearchResultAdapter$SearchResultViewHolder$1
  implements View.OnClickListener
{
  SearchResultAdapter$SearchResultViewHolder$1(SearchResultAdapter.SearchResultViewHolder paramSearchResultViewHolder, SearchInfo paramSearchInfo, MiniAppInfo paramMiniAppInfo, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        if (this.val$searchInfo.getType() == 5)
        {
          i = 3028;
          if (this.val$miniAppInfo.isWxMiniApp()) {
            ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).startWxMiniAppById(this.val$activity, this.val$miniAppInfo.appId, "", i);
          } else {
            MiniAppController.launchMiniAppByAppInfo(this.val$activity, this.val$miniAppInfo, i);
          }
          ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).updateHistorySearchList(this.val$keyword);
          paramView = new MiniAppConfig(this.val$miniAppInfo);
          paramView.launchParam.scene = 3026;
          if (this.val$searchInfo.getType() == 5) {
            paramView.launchParam.scene = 3028;
          }
          MiniProgramLpReportDC04239.reportAsync(paramView, "desktop", "search", this.val$reserves_click, this.val$keyword);
          paramView = new StringBuilder();
          paramView.append("SearchResultAdapter, click: appid=");
          paramView.append(this.val$miniAppInfo.appId);
          paramView.append(", appName=");
          paramView.append(this.val$miniAppInfo.name);
          paramView.append(", miniAppType");
          paramView.append(this.val$miniAppInfo.miniAppType);
          QLog.i("SearchResultAdapter", 1, paramView.toString());
          return;
        }
      }
      catch (Exception paramView)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SearchResultAdapter, start miniApp exception: ");
        localStringBuilder.append(Log.getStackTraceString(paramView));
        QLog.e("SearchResultAdapter", 1, localStringBuilder.toString());
        return;
      }
      int i = 3026;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.SearchResultViewHolder.1
 * JD-Core Version:    0.7.0.1
 */