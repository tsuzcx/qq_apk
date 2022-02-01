package com.tencent.mobileqq.kandian.biz.daily;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;

class DailyDynamicHeaderViewController$2
  implements View.OnClickListener
{
  DailyDynamicHeaderViewController$2(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController) {}
  
  public void onClick(View paramView)
  {
    paramView = new ActivityURIRequest(paramView.getContext(), "/pubaccount/detail");
    paramView.extra().putString("uin", String.valueOf(3434959637L));
    paramView.extra().putInt("uintype", 1008);
    paramView.extra().putInt("source", 121);
    QRoute.startUri(paramView, null);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009941", "0X8009941", 0, 0, "", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.2
 * JD-Core Version:    0.7.0.1
 */