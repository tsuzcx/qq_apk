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
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
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
    Object localObject1 = paramView.getTag(2131378926);
    Object localObject3 = paramView.getTag(2131378927);
    Context localContext;
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof String)))
    {
      localContext = paramView.getContext();
      localObject1 = (String)localObject1;
      localObject2 = paramView.getTag(2131378896);
      if (!(localObject2 instanceof Integer)) {
        break label511;
      }
    }
    label145:
    label421:
    label511:
    for (int i = ((Integer)localObject2).intValue();; i = 0)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = SearchConfigUtils.c(i);
        localObject1 = SearchConfigUtils.a((String)localObject3, 3, (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("NetSearchTemplateNewEntranceView", 2, "open Browser append suffix url = " + (String)localObject1);
        }
        if (localObject1 != null) {
          break label145;
        }
        QLog.e("NetSearchTemplateNewEntranceView", 2, "NetSearchSubView click jumpurl is null");
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = SearchConfigUtils.b((String)localObject1, i);
        break;
        UniteSearchReportController.a(null, 0, i, "0X8009D5F", 0, 0, null, null);
        localObject2 = (NetSearchTemplateNewEntranceItem)paramView.getTag(2131381651);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("project", UniteSearchReportController.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("experiment_id", UniteSearchReportController.b);
          if (localObject2 != null)
          {
            QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_relatedsearch_list").obj1(((NetSearchTemplateNewEntranceItem)localObject2).a + "").obj2(((NetSearchTemplateNewEntranceItem)localObject2).d).ver1(((NetSearchTemplateNewEntranceItem)localObject2).a()).ver2(UniteSearchReportController.a(i));
            if (localObject3 == null)
            {
              localObject2 = "";
              UniteSearchReportController.a(null, localReportModelDC02528.ver4((String)localObject2).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.a));
            }
          }
          else
          {
            if ((!((String)localObject1).startsWith("https://")) && (!((String)localObject1).startsWith("http://"))) {
              break label421;
            }
            SearchUtils.a(localContext, (String)localObject3, (String)localObject1);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("NetSearchTemplateNewEntranceView", 2, "e = " + localJSONException);
            continue;
            localObject2 = localObject3.toString();
          }
          if ((localContext instanceof BaseActivity))
          {
            localObject2 = JumpParser.a(((BaseActivity)localContext).app, localContext, (String)localObject1);
            if (localObject2 != null) {
              ((JumpAction)localObject2).a();
            } else {
              localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
            }
          }
          else
          {
            localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateNewEntranceView.NetSearchSubView.1
 * JD-Core Version:    0.7.0.1
 */