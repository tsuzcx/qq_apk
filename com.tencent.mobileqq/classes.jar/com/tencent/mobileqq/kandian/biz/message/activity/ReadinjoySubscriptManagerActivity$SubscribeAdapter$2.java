package com.tencent.mobileqq.kandian.biz.message.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;

class ReadinjoySubscriptManagerActivity$SubscribeAdapter$2
  implements View.OnClickListener
{
  ReadinjoySubscriptManagerActivity$SubscribeAdapter$2(ReadinjoySubscriptManagerActivity.SubscribeAdapter paramSubscribeAdapter, ReadinjoySubscriptManagerActivity.SubscribeFeedData paramSubscribeFeedData) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity$SubscribeAdapter.a, ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity$SubscribeFeedData));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity$SubscribeFeedData), "0X80078A8", "0X80078A8", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadinjoySubscriptManagerActivity.SubscribeAdapter.2
 * JD-Core Version:    0.7.0.1
 */