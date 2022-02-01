package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyDiandianHeaderController$OnItemViewClickListener
  implements View.OnClickListener
{
  public int a;
  
  private ReadInJoyDiandianHeaderController$OnItemViewClickListener(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onItemClick: ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("ReadInJoyDiandianHeaderController", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (DiandianTopConfig)ReadInJoyDiandianHeaderController.g(this.b).get(this.a);
    ReadInJoyUtils.a(paramView.getContext(), ((DiandianTopConfig)localObject1).jumpUrl);
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      int i = ((DiandianTopConfig)localObject1).type;
      if (i == 5) {
        paramView.put("list_URL", ((DiandianTopConfig)localObject1).jumpUrl);
      } else {
        paramView.put("list_URL", "0");
      }
      paramView.put("type", ((DiandianTopConfig)localObject1).type);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(ReadInJoyDiandianHeaderController.g(this.b).size());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.a + 1);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((DiandianTopConfig)localObject1).topicId);
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, "", "0X80092FD", "0X80092FD", 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyDiandianHeaderController", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.OnItemViewClickListener
 * JD-Core Version:    0.7.0.1
 */