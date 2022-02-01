package com.tencent.mobileqq.search.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchTemplatePresenter$3
  implements View.OnClickListener
{
  SearchTemplatePresenter$3(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateNewEntranceItem paramNetSearchTemplateNewEntranceItem, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    UniteSearchReportController.a(null, 0, this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.c, "0X8009D5D", 0, 0, null, null);
    Object localObject1 = new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.g).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver5("1").ver6("1");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{experiment_id:");
    ((StringBuilder)localObject2).append(UniteSearchReportController.b);
    ((StringBuilder)localObject2).append("}");
    UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()));
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.l))
    {
      localObject1 = SearchConfigUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.c);
      localObject1 = SearchConfigUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.b(), 0, (String)localObject1);
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("open Browser append suffix url = ");
        localStringBuilder.append((String)localObject1);
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
    }
    else
    {
      localObject1 = SearchConfigUtils.a(SearchConfigUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.l, this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.b(), 0, UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.c)), this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.c);
      ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateNewEntranceItem.b(), (String)localObject1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.3
 * JD-Core Version:    0.7.0.1
 */