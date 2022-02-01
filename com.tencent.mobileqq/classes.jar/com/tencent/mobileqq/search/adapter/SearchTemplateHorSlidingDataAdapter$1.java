package com.tencent.mobileqq.search.adapter;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalOneItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollLinstener;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class SearchTemplateHorSlidingDataAdapter$1
  implements HorizontalListView.OnScrollLinstener
{
  SearchTemplateHorSlidingDataAdapter$1(SearchTemplateHorSlidingDataAdapter paramSearchTemplateHorSlidingDataAdapter, HorizontalListView paramHorizontalListView) {}
  
  public void onScroll()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    float f = Math.round((float)(DeviceInfoUtil.k() - DisplayUtil.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F) + i) / this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_Float);
    i = 0;
    while ((i < f) && (i < this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_JavaUtilList.size()))
    {
      Object localObject1 = (NetSearchTemplateHorizontalOneItem)this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_JavaUtilList.get(i);
      if (SearchUtils.b.containsKey(localObject1))
      {
        Object localObject2 = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(localObject1);
        if (!((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean)
        {
          ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean = true;
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("project", UniteSearchReportController.a());
            localJSONObject.put("event_src", "client");
            localJSONObject.put("get_src", "web");
            localJSONObject.put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Int);
            localJSONObject.put("extra_info", ((NetSearchTemplateHorizontalOneItem)localObject1).b);
            localJSONObject.put("tepl", ((NetSearchTemplateHorizontalOneItem)localObject1).f);
          }
          catch (JSONException localJSONException)
          {
            localObject3 = SearchTemplateHorSlidingDataAdapter.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("e = ");
            localStringBuilder.append(localJSONException);
            QLog.e((String)localObject3, 2, localStringBuilder.toString());
          }
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          Object localObject3 = new ReportModelDC02528().module("all_result").action("exp_item");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((NetSearchTemplateHorizontalOneItem)localObject1).a);
          localStringBuilder.append("");
          localObject1 = ((ReportModelDC02528)localObject3).obj1(localStringBuilder.toString()).obj2(((NetSearchTemplateHorizontalOneItem)localObject1).j).ver1(((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_Int)).ver7(localJSONObject.toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentAccountUin());
          ((StringBuilder)localObject2).append(SearchUtils.d);
          UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter.1
 * JD-Core Version:    0.7.0.1
 */