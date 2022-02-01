package com.tencent.mobileqq.profilecard.bussiness.circle;

import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class ProfileCircleComponent$1
  implements View.OnClickListener
{
  ProfileCircleComponent$1(ProfileCircleComponent paramProfileCircleComponent, ProfileCardInfo paramProfileCardInfo, Card paramCard, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", this.val$cardInfo.card.uin);
    localHashMap.put("key_jump_from", "5");
    localHashMap.put("xsj_main_entrance", "qq_profile");
    QCircleUtils.a().enterBySchemeAction(BaseApplication.getContext(), "openmainpage", localHashMap);
    if (!TextUtils.isEmpty(ProfileCircleComponent.access$800(this.this$0)))
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.val$card.uin).setActionType(3).setSubActionType(1).setThrActionType(4));
      ProfileCircleComponent.access$802(this.this$0, null);
      if ((ProfileCircleComponent.access$400() != null) && (ProfileCircleComponent.access$400().size() > 0)) {
        ProfileCircleComponent.access$400().remove(this.val$card.uin);
      }
    }
    else
    {
      localHashMap = new HashMap();
      localHashMap.put("ext1", ProfileCircleComponent.access$900(this.this$0));
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.val$card.uin).setActionType(3).setSubActionType(1).setThrActionType(2).setExtras(localHashMap));
    }
    ProfileCardReport.reportQQCircleClick(this.val$app, this.val$cardInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.1
 * JD-Core Version:    0.7.0.1
 */