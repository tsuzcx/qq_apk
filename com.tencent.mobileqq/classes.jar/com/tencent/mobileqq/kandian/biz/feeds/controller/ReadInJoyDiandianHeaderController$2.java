package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.channel.banner.RollViewPager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyDiandianHeaderController$2
  extends ReadInJoyObserver
{
  ReadInJoyDiandianHeaderController$2(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void d(boolean paramBoolean, List<DiandianTopConfig> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (paramList.size() != 0) && (!ReadInJoyDiandianHeaderController.a(this.a).a()))
    {
      ReadInJoyDiandianHeaderController.a(this.a).setVisibility(0);
      ReadInJoyDiandianHeaderController.a(this.a, false);
      ReadInJoyDiandianHeaderController.a(this.a).clear();
      ReadInJoyDiandianHeaderController.b(this.a).clear();
      ReadInJoyDiandianHeaderController.b(this.a).addAll(paramList);
      int i;
      if (ReadInJoyDiandianHeaderController.b(this.a).size() % 2 == 0) {
        i = ReadInJoyDiandianHeaderController.b(this.a).size() / 2;
      } else {
        i = ReadInJoyDiandianHeaderController.b(this.a).size() / 2 + 1;
      }
      int j = 0;
      while (j < i)
      {
        Object localObject1 = new MeasureGridView(this.a.jdField_a_of_type_AndroidContentContext);
        paramList = this.a;
        paramList = new ReadInJoyDiandianHeaderController.HeaderListAdapter(paramList, ReadInJoyDiandianHeaderController.b(paramList), j);
        ((MeasureGridView)localObject1).setNumColumns(2);
        ((MeasureGridView)localObject1).setAdapter(paramList);
        ((MeasureGridView)localObject1).setSelector(new ColorDrawable(0));
        ReadInJoyDiandianHeaderController.a(this.a).add(localObject1);
        if (j == 0)
        {
          int k = 0;
          while (k < paramList.getCount())
          {
            localObject1 = (DiandianTopConfig)paramList.getItem(k);
            if ((localObject1 != null) && (!((DiandianTopConfig)localObject1).hasExposeReported)) {
              try
              {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
                int m = ((DiandianTopConfig)localObject1).type;
                if (m == 5) {
                  localJSONObject.put("list_URL", ((DiandianTopConfig)localObject1).jumpUrl);
                } else {
                  localJSONObject.put("list_URL", "0");
                }
                localJSONObject.put("type", ((DiandianTopConfig)localObject1).type);
                IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
                Object localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(ReadInJoyDiandianHeaderController.b(this.a).size());
                ((StringBuilder)localObject2).append("");
                localObject2 = ((StringBuilder)localObject2).toString();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(((DiandianTopConfig)localObject1).topicId);
                localStringBuilder.append("");
                localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80092FC", "0X80092FC", 0, 0, (String)localObject2, "1", localStringBuilder.toString(), localJSONObject.toString(), false);
                ((DiandianTopConfig)localObject1).hasExposeReported = true;
                paramList.a(k, (DiandianTopConfig)localObject1);
              }
              catch (JSONException localJSONException)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("ReadInJoyDiandianHeaderController", 2, localJSONException.toString());
                }
              }
            }
            k += 1;
          }
        }
        j += 1;
      }
      ReadInJoyDiandianHeaderController.a(this.a).a(ReadInJoyDiandianHeaderController.a(this.a));
      if (i > 1)
      {
        paramList = this.a;
        paramList.jdField_a_of_type_Int = 1;
        ReadInJoyDiandianHeaderController.a(paramList).setCurrentItem(this.a.jdField_a_of_type_Int, false);
        this.a.f();
      }
    }
    else
    {
      ReadInJoyDiandianHeaderController.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.2
 * JD-Core Version:    0.7.0.1
 */