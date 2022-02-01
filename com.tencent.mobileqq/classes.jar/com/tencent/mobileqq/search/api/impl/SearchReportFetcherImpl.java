package com.tencent.mobileqq.search.api.impl;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelCreateDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroopMember;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchReportFetcherImpl
  implements ISearchReportFetcher
{
  public String getReportType(ISearchResultModel paramISearchResultModel)
  {
    if ((!(paramISearchResultModel instanceof ContactSearchModelDiscussion)) && (!(paramISearchResultModel instanceof ContactSearchModelCreateDiscussion)) && (!(paramISearchResultModel instanceof ContactSearchModelDiscussionMember)))
    {
      if ((!(paramISearchResultModel instanceof ContactSearchModelGlobalTroop)) && (!(paramISearchResultModel instanceof ContactSearchModelGlobalTroopMember)) && (!(paramISearchResultModel instanceof ContactSearchModelTroop)) && (!(paramISearchResultModel instanceof ContactSearchModelTroopMember)) && (!(paramISearchResultModel instanceof ContactSearchModelNewTroop)) && (!(paramISearchResultModel instanceof ContactSearchModelNewTroopMember))) {
        return HardCodeUtil.a(2131903668);
      }
      return HardCodeUtil.a(2131903667);
    }
    return HardCodeUtil.a(2131903666);
  }
  
  public void onActionContactSearchModel(ISearchResultModel paramISearchResultModel, View paramView, String paramString1, int paramInt, String paramString2)
  {
    if (SearchUtils.b(paramInt))
    {
      Object localObject1 = (Integer)paramView.getTag(2131449868);
      Integer localInteger = (Integer)paramView.getTag(2131449866);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" view.getTag(R.id.view_tag_position) = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("Q.uniteSearch..ContectReport", 2, ((StringBuilder)localObject2).toString());
      }
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtils.l.containsKey(this)))
      {
        Object localObject3 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("project", UniteSearchReportController.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject3).c);
          localJSONObject.put("get_src", "native");
        }
        catch (JSONException localJSONException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("e = ");
          localStringBuilder2.append(localJSONException);
          QLog.e(paramString2, 2, localStringBuilder2.toString());
        }
        paramString2 = new ReportModelDC02528().module("all_result").action("clk_item");
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(((SearchUtils.ObjectItemInfo)localObject3).b);
        localStringBuilder1.append("");
        paramString2 = paramString2.obj1(localStringBuilder1.toString()).obj2(((SearchUtils.ObjectItemInfo)localObject3).e).ver1(((SearchUtils.ObjectItemInfo)localObject3).a).ver2(UniteSearchReportController.a(paramInt)).ver7(localJSONObject.toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((QQAppInterface)localObject2).getCurrentAccountUin());
        ((StringBuilder)localObject3).append(SearchUtils.j);
        UniteSearchReportController.a(null, paramString2.session_id(((StringBuilder)localObject3).toString()));
      }
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (!(paramISearchResultModel instanceof PublicAccountSearchResultModel)) && (localInteger.intValue() >= 0) && (((Integer)localObject1).intValue() >= 0))
      {
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append(paramString1);
        paramView = paramView.toString();
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(localInteger);
        paramString1 = paramString1.toString();
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(((Integer)localObject1).intValue() + 1);
        paramString2 = paramString2.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(getReportType(paramISearchResultModel));
        SearchUtils.a("all_result", "clk_contact", new String[] { paramView, paramString1, paramString2, ((StringBuilder)localObject1).toString() });
        return;
      }
      if (((paramView.getContext() instanceof ContactSearchActivity)) && (!(paramISearchResultModel instanceof PublicAccountSearchResultModel)))
      {
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append(paramString1);
        paramView = paramView.toString();
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(localInteger);
        paramString1 = paramString1.toString();
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(((Integer)localObject1).intValue() + 1);
        paramString2 = paramString2.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(getReportType(paramISearchResultModel));
        SearchUtils.a("contact", "clk_result", new String[] { paramView, paramString1, paramString2, ((StringBuilder)localObject1).toString() });
        return;
      }
      if (((paramView.getContext() instanceof UniteSearchActivity)) && ((paramISearchResultModel instanceof PublicAccountSearchResultModel)))
      {
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append(paramString1);
        paramView = paramView.toString();
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(localInteger);
        paramString1 = paramString1.toString();
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(((Integer)localObject1).intValue() + 1);
        paramString2 = paramString2.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(getReportType(paramISearchResultModel));
        SearchUtils.a("all_result", "clk_public_uin", new String[] { paramView, paramString1, paramString2, ((StringBuilder)localObject1).toString() });
        return;
      }
      if ((!(paramView.getContext() instanceof UniteSearchActivity)) && ((paramISearchResultModel instanceof PublicAccountSearchResultModel)))
      {
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append(paramString1);
        paramView = paramView.toString();
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(localInteger);
        paramString1 = paramString1.toString();
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(((Integer)localObject1).intValue() + 1);
        paramString2 = paramString2.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(getReportType(paramISearchResultModel));
        SearchUtils.a("all_result", "clk_public_uin_page", new String[] { paramView, paramString1, paramString2, ((StringBuilder)localObject1).toString() });
      }
    }
  }
  
  public void onReportClick898(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    UniteSearchReportController.a(null, 0, paramInt2, paramString1, 0, 0, null, null);
  }
  
  public void onReportRuntimeDC02528(AppInterface paramAppInterface, long paramLong, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    paramString1 = localReportModelDC02528.obj1(localStringBuilder.toString()).obj2(paramString1).ver1(paramString2).ver2(UniteSearchReportController.a(UniteSearchActivity.f)).ver7(paramJSONObject.toString());
    paramString2 = new StringBuilder();
    paramString2.append(paramAppInterface.getCurrentAccountUin());
    paramString2.append(SearchUtils.j);
    UniteSearchReportController.a(null, paramString1.session_id(paramString2.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.impl.SearchReportFetcherImpl
 * JD-Core Version:    0.7.0.1
 */