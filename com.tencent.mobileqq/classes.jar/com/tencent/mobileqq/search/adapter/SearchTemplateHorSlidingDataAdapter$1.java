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
    int i = this.a.getCurrentX();
    float f = Math.round((float)(DeviceInfoUtil.F() - DisplayUtil.a(this.a.getContext(), 13.5F) + i) / this.b.f);
    i = 0;
    while ((i < f) && (i < this.b.b.size()))
    {
      Object localObject1 = (NetSearchTemplateHorizontalOneItem)this.b.b.get(i);
      if (SearchUtils.l.containsKey(localObject1))
      {
        Object localObject2 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(localObject1);
        if (!((SearchUtils.ObjectItemInfo)localObject2).d)
        {
          ((SearchUtils.ObjectItemInfo)localObject2).d = true;
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("project", UniteSearchReportController.a());
            localJSONObject.put("event_src", "client");
            localJSONObject.put("get_src", "web");
            localJSONObject.put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject2).c);
            localJSONObject.put("extra_info", ((NetSearchTemplateHorizontalOneItem)localObject1).d);
            localJSONObject.put("tepl", ((NetSearchTemplateHorizontalOneItem)localObject1).l);
          }
          catch (JSONException localJSONException)
          {
            localObject3 = SearchTemplateHorSlidingDataAdapter.a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("e = ");
            localStringBuilder.append(localJSONException);
            QLog.e((String)localObject3, 2, localStringBuilder.toString());
          }
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          Object localObject3 = new ReportModelDC02528().module("all_result").action("exp_item");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((NetSearchTemplateHorizontalOneItem)localObject1).i);
          localStringBuilder.append("");
          localObject1 = ((ReportModelDC02528)localObject3).obj1(localStringBuilder.toString()).obj2(((NetSearchTemplateHorizontalOneItem)localObject1).e).ver1(((SearchUtils.ObjectItemInfo)localObject2).a).ver2(UniteSearchReportController.a(this.b.d)).ver7(localJSONObject.toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentAccountUin());
          ((StringBuilder)localObject2).append(SearchUtils.j);
          UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter.1
 * JD-Core Version:    0.7.0.1
 */