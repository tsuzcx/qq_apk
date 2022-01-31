package com.tencent.mobileqq.search.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateHorizontalBaseItem
  extends NetSearchTemplateBaseItem
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  public JSONObject a;
  public String b;
  public String j;
  
  static
  {
    jdField_a_of_type_JavaLangString = NetSearchTemplateHorizontalBaseItem.class.getSimpleName();
  }
  
  protected NetSearchTemplateHorizontalBaseItem(String paramString, long paramLong, List paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt1);
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_Int = paramInt2;
    b(paramJSONObject);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  public void a(View paramView)
  {
    SearchUtil.ObjectItemInfo localObjectItemInfo;
    JSONObject localJSONObject;
    if (SearchUtil.c.containsKey(this))
    {
      localObjectItemInfo = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(this);
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", UniteSearchReportController.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localObjectItemInfo.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      localJSONObject.put("extra_info", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("tepl", this.f);
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(this.jdField_a_of_type_Long + "").obj2(this.j).ver1(this.g).ver2(UniteSearchReportController.a(this.jdField_b_of_type_Int)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
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
  
  public void a(NetSearchTemplateHorizontalBaseView paramNetSearchTemplateHorizontalBaseView) {}
  
  public void b(JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalBaseItem
 * JD-Core Version:    0.7.0.1
 */