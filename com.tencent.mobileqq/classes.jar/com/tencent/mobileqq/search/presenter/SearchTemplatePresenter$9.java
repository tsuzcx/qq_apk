package com.tencent.mobileqq.search.presenter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem.ActionInfo;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class SearchTemplatePresenter$9
  implements View.OnClickListener
{
  SearchTemplatePresenter$9(SearchTemplatePresenter paramSearchTemplatePresenter, Context paramContext, NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    SearchUtils.a(localQQAppInterface, this.a, this.b.a.c);
    if (SearchUtils.l.containsKey(this.b))
    {
      Object localObject1 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this.b);
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject2).put("event_src", "client");
        ((JSONObject)localObject2).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject1).c);
        ((JSONObject)localObject2).put("get_src", "web");
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, localStringBuilder.toString());
      }
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((SearchUtils.ObjectItemInfo)localObject1).b);
      localStringBuilder.append("");
      localObject1 = localReportModelDC02528.obj1(localStringBuilder.toString()).obj2(((SearchUtils.ObjectItemInfo)localObject1).e).ver1(((SearchUtils.ObjectItemInfo)localObject1).a).ver2(UniteSearchReportController.a(this.b.p)).ver7(((JSONObject)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append(SearchUtils.j);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.9
 * JD-Core Version:    0.7.0.1
 */