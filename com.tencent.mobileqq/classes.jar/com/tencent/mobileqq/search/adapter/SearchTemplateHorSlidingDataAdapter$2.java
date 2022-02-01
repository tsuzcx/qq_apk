package com.tencent.mobileqq.search.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchUtil;
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
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", UniteSearchReportController.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("get_src", "web");
      UniteSearchReportController.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("clk_more").obj1(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_Long + "").ver1(UniteSearchActivity.b).ver2(UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_Int)).ver3("right").ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(SearchTemplateHorSlidingDataAdapter.jdField_a_of_type_JavaLangString, 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter.2
 * JD-Core Version:    0.7.0.1
 */