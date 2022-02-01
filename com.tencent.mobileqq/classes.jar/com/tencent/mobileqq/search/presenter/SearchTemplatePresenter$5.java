package com.tencent.mobileqq.search.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.net.model.NetSearchSubItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SearchTemplatePresenter$5
  implements View.OnClickListener
{
  SearchTemplatePresenter$5(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateNetSeaEntranceItem paramNetSearchTemplateNetSeaEntranceItem, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNetSeaEntranceItem.m))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNetSeaEntranceItem.b();
      Object localObject2 = UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNetSeaEntranceItem.c);
      int i = 0;
      localObject1 = SearchConfigUtils.a((String)localObject1, 0, (String)localObject2);
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      localObject1 = new StringBuilder();
      while (i < this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNetSeaEntranceItem.a.size())
      {
        if (i != this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNetSeaEntranceItem.a.size() - 1)
        {
          ((StringBuilder)localObject1).append(((NetSearchSubItem)this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNetSeaEntranceItem.a.get(i)).b);
          ((StringBuilder)localObject1).append("::");
        }
        else
        {
          ((StringBuilder)localObject1).append(((NetSearchSubItem)this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNetSeaEntranceItem.a.get(i)).b);
        }
        i += 1;
      }
      localObject1 = new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNetSeaEntranceItem.g).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver4(((StringBuilder)localObject1).toString()).ver5("1").ver6("2");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("{experiment_id:");
      ((StringBuilder)localObject2).append(UniteSearchReportController.b);
      ((StringBuilder)localObject2).append("}");
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.5
 * JD-Core Version:    0.7.0.1
 */