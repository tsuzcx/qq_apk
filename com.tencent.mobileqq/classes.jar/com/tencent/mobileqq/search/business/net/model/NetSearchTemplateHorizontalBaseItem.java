package com.tencent.mobileqq.search.business.net.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateHorizontalBaseItem
  extends NetSearchTemplateBaseItem
  implements View.OnClickListener
{
  public static final String a = "NetSearchTemplateHorizontalBaseItem";
  public int a;
  public JSONObject a;
  public String b;
  public String j;
  
  protected NetSearchTemplateHorizontalBaseItem(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt1);
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_Int = paramInt2;
    b(paramJSONObject);
  }
  
  protected NetSearchTemplateHorizontalBaseItem(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem)
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
    if (SearchUtils.b.containsKey(this))
    {
      SearchUtils.ObjectItemInfo localObjectItemInfo = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
      paramView = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
      Object localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject1).put("event_src", "client");
        ((JSONObject)localObject1).put("obj_lct", localObjectItemInfo.jdField_a_of_type_Int);
        ((JSONObject)localObject1).put("get_src", "web");
        ((JSONObject)localObject1).put("extra_info", this.b);
        ((JSONObject)localObject1).put("tepl", this.f);
      }
      catch (JSONException localJSONException)
      {
        localObject3 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e((String)localObject3, 2, localStringBuilder.toString());
      }
      Object localObject2 = new ReportModelDC02528().module("all_result").action("clk_item");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject3).append("");
      localObject1 = ((ReportModelDC02528)localObject2).obj1(((StringBuilder)localObject3).toString()).obj2(this.j).ver1(this.g).ver2(UniteSearchReportController.a(this.c)).ver7(((JSONObject)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramView.getCurrentAccountUin());
      ((StringBuilder)localObject2).append(SearchUtils.d);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
    }
  }
  
  public void a(NetSearchTemplateHorizontalBaseView paramNetSearchTemplateHorizontalBaseView) {}
  
  public void b(JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem
 * JD-Core Version:    0.7.0.1
 */