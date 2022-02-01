package com.tencent.mobileqq.kandian.biz.message.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;

class ReadinjoySubscriptManagerActivity$SubscribeAdapter$2
  implements View.OnClickListener
{
  ReadinjoySubscriptManagerActivity$SubscribeAdapter$2(ReadinjoySubscriptManagerActivity.SubscribeAdapter paramSubscribeAdapter, ReadinjoySubscriptManagerActivity.SubscribeFeedData paramSubscribeFeedData) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.b.a, ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(this.a));
    PublicAccountReportUtils.a(null, "CliOper", "", ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(this.a), "0X80078A8", "0X80078A8", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadinjoySubscriptManagerActivity.SubscribeAdapter.2
 * JD-Core Version:    0.7.0.1
 */