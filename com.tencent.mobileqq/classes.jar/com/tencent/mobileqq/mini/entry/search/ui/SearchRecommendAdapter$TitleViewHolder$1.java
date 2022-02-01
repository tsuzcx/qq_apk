package com.tencent.mobileqq.mini.entry.search.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchRecommendAdapter$TitleViewHolder$1
  implements View.OnClickListener
{
  SearchRecommendAdapter$TitleViewHolder$1(SearchRecommendAdapter.TitleViewHolder paramTitleViewHolder) {}
  
  public void onClick(View paramView)
  {
    ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).sendGuessYouLikeRequest();
    MiniProgramLpReportDC04239.reportAsync("desktop", "inference", "refresh_click", null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.TitleViewHolder.1
 * JD-Core Version:    0.7.0.1
 */