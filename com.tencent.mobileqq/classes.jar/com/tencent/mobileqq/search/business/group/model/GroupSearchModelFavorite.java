package com.tencent.mobileqq.search.business.group.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.model.BaseSearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchModelFavorite
  extends BaseSearchResultGroupModel
{
  public static final String a = "GroupSearchModelFavorite";
  public static final String b = HardCodeUtil.a(2131903360);
  private List<ISearchResultModel> c;
  private String d;
  
  public GroupSearchModelFavorite(List<ISearchResultModel> paramList, String paramString)
  {
    this.c = paramList;
    this.d = paramString;
    a(15);
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131903366);
  }
  
  public void a(View paramView)
  {
    if ((((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) && (SearchUtils.l.containsKey(this)))
    {
      Object localObject2 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
      localObject1 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      Object localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject2).c);
        ((JSONObject)localObject3).put("get_src", "native");
      }
      catch (JSONException localJSONException)
      {
        localObject4 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e((String)localObject4, 2, localStringBuilder.toString());
      }
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((SearchUtils.ObjectItemInfo)localObject2).b);
      ((StringBuilder)localObject4).append("");
      localObject2 = localReportModelDC02528.obj1(((StringBuilder)localObject4).toString()).obj2(((SearchUtils.ObjectItemInfo)localObject2).e).ver1(((SearchUtils.ObjectItemInfo)localObject2).a).ver2(UniteSearchReportController.a(((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getFromForHistoryCode())).ver7(((JSONObject)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((AppInterface)localObject1).getCurrentAccountUin());
      ((StringBuilder)localObject3).append(SearchUtils.j);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject2).session_id(((StringBuilder)localObject3).toString()));
    }
    Object localObject1 = (QBaseActivity)paramView.getContext();
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToFavoriteSearchActivity((Context)localObject1, this.d);
    ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).refreshFavList((Activity)localObject1, ((QBaseActivity)localObject1).getAppRuntime().getAccount(), 0L);
    SearchUtils.a(this.d, 60, 0, paramView);
    SearchReportUtil.a(e(), f(), c(), b);
    UniteSearchReportController.a(null, e(), 0, "0X8009D55", 0, 0, null, null);
  }
  
  public List<ISearchResultModel> b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite
 * JD-Core Version:    0.7.0.1
 */