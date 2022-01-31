package com.tencent.mobileqq.filemanager.data.search;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchModelFileEntity
  implements ISearchResultGroupModel
{
  public static final String a;
  List a;
  String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = GroupSearchModelFileEntity.class.getSimpleName();
  }
  
  public GroupSearchModelFileEntity(List paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return "文件";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtil.ObjectItemInfo localObjectItemInfo;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtil.c.containsKey(this)))
    {
      localObjectItemInfo = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", UniteSearchReportController.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localObjectItemInfo.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localObjectItemInfo.jdField_a_of_type_Long + "").obj2(localObjectItemInfo.b).ver1(localObjectItemInfo.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      SearchUtils.a(this.b, 100, 0, paramView);
      FileManagerReporter.a("0X8006061");
      FileSearchActivity.a(paramView.getContext(), this.b, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
      }
    }
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.GroupSearchModelFileEntity
 * JD-Core Version:    0.7.0.1
 */