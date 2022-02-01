package com.tencent.mobileqq.search.business.group.model;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
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
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchModelFileEntity
  implements ISearchResultGroupModel
{
  public static final String a = "GroupSearchModelFileEntity";
  public static final String b = HardCodeUtil.a(2131705481);
  int jdField_a_of_type_Int = -1;
  List<ISearchResultModel> jdField_a_of_type_JavaUtilList;
  String c;
  
  public GroupSearchModelFileEntity(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.c = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 3;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131705463);
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    if ((((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) && (SearchUtils.b.containsKey(this)))
    {
      Object localObject1 = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
      AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject2).put("event_src", "client");
        ((JSONObject)localObject2).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject1).jdField_a_of_type_Int);
        ((JSONObject)localObject2).put("get_src", "native");
      }
      catch (JSONException localJSONException)
      {
        localObject3 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e((String)localObject3, 2, localStringBuilder.toString());
      }
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((SearchUtils.ObjectItemInfo)localObject1).jdField_a_of_type_Long);
      ((StringBuilder)localObject3).append("");
      localObject1 = localReportModelDC02528.obj1(((StringBuilder)localObject3).toString()).obj2(((SearchUtils.ObjectItemInfo)localObject1).b).ver1(((SearchUtils.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getFromForHistoryCode())).ver7(((JSONObject)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append(SearchUtils.d);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
    }
    SearchUtils.a(this.c, 100, 0, paramView);
    FileManagerReporter.a("0X8006061");
    UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0x8009D5B", 0, 0, null, null);
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToFileSearchActivity(paramView.getContext(), this.c, this.jdField_a_of_type_JavaUtilList, true, this.jdField_a_of_type_Int);
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > a()) {
      UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0x8009D5A", 0, 0, null, null);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity
 * JD-Core Version:    0.7.0.1
 */