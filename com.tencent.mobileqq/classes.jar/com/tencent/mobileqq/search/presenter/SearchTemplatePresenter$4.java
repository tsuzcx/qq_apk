package com.tencent.mobileqq.search.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchTemplatePresenter$4
  implements View.OnClickListener
{
  SearchTemplatePresenter$4(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateNetSeaEntranceItem paramNetSearchTemplateNetSeaEntranceItem, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateNetSeaEntranceItem.m))
    {
      String str = SearchConfigUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateNetSeaEntranceItem.a(), 0, UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateNetSeaEntranceItem.c));
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateNetSeaEntranceItem.g).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver5("1").ver6("1").ver7("{experiment_id:" + UniteSearchReportController.b + "}"));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.4
 * JD-Core Version:    0.7.0.1
 */