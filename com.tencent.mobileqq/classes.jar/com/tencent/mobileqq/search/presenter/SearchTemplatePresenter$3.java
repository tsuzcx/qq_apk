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
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchTemplatePresenter$3
  implements View.OnClickListener
{
  SearchTemplatePresenter$3(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateNewEntranceItem paramNetSearchTemplateNewEntranceItem, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    UniteSearchReportController.a(null, 0, this.a.p, "0X8009D5D", 0, 0, null, null);
    Object localObject1 = new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.a.m).ver2(UniteSearchReportController.a(UniteSearchActivity.f)).ver5("1").ver6("1");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{experiment_id:");
    ((StringBuilder)localObject2).append(UniteSearchReportController.b);
    ((StringBuilder)localObject2).append("}");
    UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()));
    if (TextUtils.isEmpty(this.a.f))
    {
      SearchUtils.a("后台没有配置链接，终端拼接跳转");
      localObject1 = SearchConfigUtils.c(this.a.p);
      localObject1 = SearchConfigUtils.a(this.a.g(), 0, (String)localObject1);
      localObject2 = new Intent(this.b, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("open Browser append suffix url = ");
        localStringBuilder.append((String)localObject1);
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, localStringBuilder.toString());
      }
      this.b.startActivity((Intent)localObject2);
    }
    else
    {
      SearchUtils.a("后台配置了链接，使用后台链接跳转");
      localObject1 = SearchConfigUtils.a(SearchConfigUtils.a(this.a.f, this.a.g(), 0, UniteSearchReportController.a(this.a.p)), this.a.p);
      ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(this.b, this.a.g(), (String)localObject1);
      SearchReportUtil.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.3
 * JD-Core Version:    0.7.0.1
 */