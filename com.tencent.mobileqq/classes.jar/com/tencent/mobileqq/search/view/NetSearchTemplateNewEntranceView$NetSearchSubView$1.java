package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class NetSearchTemplateNewEntranceView$NetSearchSubView$1
  implements View.OnClickListener
{
  NetSearchTemplateNewEntranceView$NetSearchSubView$1(NetSearchTemplateNewEntranceView.NetSearchSubView paramNetSearchSubView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131446833);
    Object localObject4 = paramView.getTag(2131446835);
    if ((localObject1 != null) && ((localObject1 instanceof String)))
    {
      Context localContext = paramView.getContext();
      localObject1 = (String)localObject1;
      Object localObject2 = paramView.getTag(2131446804);
      int i = 0;
      if ((localObject2 instanceof Integer)) {
        i = ((Integer)localObject2).intValue();
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        SearchUtils.a("后台没有配置链接，终端拼接跳转");
        localObject1 = SearchConfigUtils.e(i);
        localObject1 = SearchConfigUtils.a((String)localObject4, 3, (String)localObject1);
      }
      else
      {
        SearchUtils.a("后台配置了链接，使用后台链接跳转");
        localObject1 = SearchConfigUtils.b((String)localObject1, i);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("open Browser append suffix url = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("NetSearchTemplateNewEntranceView", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 == null)
      {
        QLog.e("NetSearchTemplateNewEntranceView", 2, "NetSearchSubView click jumpurl is null");
      }
      else
      {
        UniteSearchReportController.a(null, 0, i, "0X8009D5F", 0, 0, null, null);
        NetSearchTemplateNewEntranceItem localNetSearchTemplateNewEntranceItem = (NetSearchTemplateNewEntranceItem)paramView.getTag(2131449867);
        Object localObject5 = new JSONObject();
        Object localObject6;
        try
        {
          ((JSONObject)localObject5).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject5).put("event_src", "client");
          ((JSONObject)localObject5).put("experiment_id", UniteSearchReportController.b);
        }
        catch (JSONException localJSONException)
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("e = ");
          ((StringBuilder)localObject6).append(localJSONException);
          QLog.e("NetSearchTemplateNewEntranceView", 2, ((StringBuilder)localObject6).toString());
        }
        Object localObject3;
        if (localNetSearchTemplateNewEntranceItem != null)
        {
          localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_relatedsearch_list");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localNetSearchTemplateNewEntranceItem.i);
          localObject3 = "";
          localStringBuilder.append("");
          localReportModelDC02528 = localReportModelDC02528.obj1(localStringBuilder.toString()).obj2(localNetSearchTemplateNewEntranceItem.h).ver1(localNetSearchTemplateNewEntranceItem.g()).ver2(UniteSearchReportController.a(i));
          if (localObject4 != null) {
            localObject3 = localObject4.toString();
          }
          localObject3 = localReportModelDC02528.ver4((String)localObject3).ver7(((JSONObject)localObject5).toString());
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((QQAppInterface)localObject6).getCurrentAccountUin());
          ((StringBuilder)localObject5).append(SearchUtils.j);
          UniteSearchReportController.a(null, ((ReportModelDC02528)localObject3).session_id(((StringBuilder)localObject5).toString()));
        }
        if ((!((String)localObject1).startsWith("https://")) && (!((String)localObject1).startsWith("http://")))
        {
          if ((localContext instanceof BaseActivity))
          {
            localObject3 = JumpParser.a(((BaseActivity)localContext).app, localContext, (String)localObject1);
            if (localObject3 != null) {
              ((JumpAction)localObject3).a();
            } else {
              localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
            }
          }
          else
          {
            localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
          }
        }
        else {
          ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(localContext, (String)localObject4, (String)localObject1);
        }
        SearchReportUtil.a(localNetSearchTemplateNewEntranceItem.ah, 20, localNetSearchTemplateNewEntranceItem.g(), (String)localObject4);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateNewEntranceView.NetSearchSubView.1
 * JD-Core Version:    0.7.0.1
 */