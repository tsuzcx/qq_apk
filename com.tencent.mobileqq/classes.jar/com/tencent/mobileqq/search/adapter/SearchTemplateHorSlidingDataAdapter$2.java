package com.tencent.mobileqq.search.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class SearchTemplateHorSlidingDataAdapter$2
  implements View.OnClickListener
{
  SearchTemplateHorSlidingDataAdapter$2(SearchTemplateHorSlidingDataAdapter paramSearchTemplateHorSlidingDataAdapter, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidViewViewGroup.getContext(), this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.m);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
      ((JSONObject)localObject1).put("event_src", "client");
      ((JSONObject)localObject1).put("get_src", "web");
    }
    catch (JSONException localJSONException)
    {
      localObject3 = SearchTemplateHorSlidingDataAdapter.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("e = ");
      localStringBuilder.append(localJSONException);
      QLog.e((String)localObject3, 2, localStringBuilder.toString());
    }
    Object localObject2 = new ReportModelDC02528().module("all_result").action("clk_more");
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_Long);
    ((StringBuilder)localObject3).append("");
    localObject1 = ((ReportModelDC02528)localObject2).obj1(((StringBuilder)localObject3).toString()).ver1(UniteSearchActivity.b).ver2(UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_Int)).ver3("right").ver7(((JSONObject)localObject1).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject2).append(SearchUtils.d);
    UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter.2
 * JD-Core Version:    0.7.0.1
 */