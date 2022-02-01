package com.tencent.mobileqq.search.adapter;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalOneItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
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
    long l1 = DeviceInfoUtil.k();
    long l2 = DisplayUtil.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_Float);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_JavaUtilList.size()))
      {
        NetSearchTemplateHorizontalOneItem localNetSearchTemplateHorizontalOneItem = (NetSearchTemplateHorizontalOneItem)this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_JavaUtilList.get(i);
        SearchUtil.ObjectItemInfo localObjectItemInfo;
        JSONObject localJSONObject;
        if (SearchUtil.b.containsKey(localNetSearchTemplateHorizontalOneItem))
        {
          localObjectItemInfo = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(localNetSearchTemplateHorizontalOneItem);
          if (!localObjectItemInfo.jdField_a_of_type_Boolean)
          {
            localObjectItemInfo.jdField_a_of_type_Boolean = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", UniteSearchReportController.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", localObjectItemInfo.jdField_a_of_type_Int);
          localJSONObject.put("extra_info", localNetSearchTemplateHorizontalOneItem.b);
          localJSONObject.put("tepl", localNetSearchTemplateHorizontalOneItem.f);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          UniteSearchReportController.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localNetSearchTemplateHorizontalOneItem.a + "").obj2(localNetSearchTemplateHorizontalOneItem.j).ver1(localObjectItemInfo.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSearchTemplateHorSlidingDataAdapter.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.a));
          i += 1;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter.1
 * JD-Core Version:    0.7.0.1
 */