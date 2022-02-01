package com.tencent.mobileqq.profilecard.bussiness.circle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class ProfileCircleComponent$2
  implements View.OnClickListener
{
  ProfileCircleComponent$2(ProfileCircleComponent paramProfileCircleComponent) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ProfileCircleComponent", 4, "qqCircleWriteEntrance onClick");
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_is_publish", "1");
    localHashMap.put("key_jump_from", "5");
    localHashMap.put("xsj_main_entrance", "qq_profile");
    QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.getContext(), "openfolder", localHashMap);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 3, 2, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.2
 * JD-Core Version:    0.7.0.1
 */