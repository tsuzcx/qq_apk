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
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
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
  implements ISearchResultGroupModel
{
  public static final String a = "GroupSearchModelFavorite";
  public static final String b = HardCodeUtil.a(2131705472);
  private List<ISearchResultModel> a;
  private String c;
  
  public GroupSearchModelFavorite(List<ISearchResultModel> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.c = paramString;
  }
  
  public int a()
  {
    return 0;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131705478);
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    if ((((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) && (SearchUtils.b.containsKey(this)))
    {
      Object localObject2 = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
      localObject1 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      Object localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Int);
        ((JSONObject)localObject3).put("get_src", "native");
      }
      catch (JSONException localJSONException)
      {
        localObject4 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e((String)localObject4, 2, localStringBuilder.toString());
      }
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Long);
      ((StringBuilder)localObject4).append("");
      localObject2 = localReportModelDC02528.obj1(((StringBuilder)localObject4).toString()).obj2(((SearchUtils.ObjectItemInfo)localObject2).b).ver1(((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getFromForHistoryCode())).ver7(((JSONObject)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((AppInterface)localObject1).getCurrentAccountUin());
      ((StringBuilder)localObject3).append(SearchUtils.d);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject2).session_id(((StringBuilder)localObject3).toString()));
    }
    Object localObject1 = (QBaseActivity)paramView.getContext();
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToFavoriteSearchActivity((Context)localObject1, this.c);
    ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).refreshFavList((Activity)localObject1, ((QBaseActivity)localObject1).getAppRuntime().getAccount(), 0L);
    SearchUtils.a(this.c, 60, 0, paramView);
  }
  
  public String b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite
 * JD-Core Version:    0.7.0.1
 */