package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.SimpleFeedbackPopupWindow.Callback;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelWaterFallViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils.ReportData;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import org.json.JSONObject;

class ReadInJoyPicWaterFallFragment$4
  implements SimpleFeedbackPopupWindow.Callback
{
  ReadInJoyPicWaterFallFragment$4(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.a.c.a(paramAbsBaseArticleInfo, paramInt);
    JSONObject localJSONObject = GalleryReportedUtils.a(this.a.v(), this.a.d(), 3, paramInt, paramAbsBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      Object localObject = new GalleryReportedUtils.ReportData(paramAbsBaseArticleInfo);
      ((GalleryReportedUtils.ReportData)localObject).f = String.valueOf(paramAbsBaseArticleInfo.mArticleID);
      ((GalleryReportedUtils.ReportData)localObject).g = String.valueOf(paramAbsBaseArticleInfo.mStrategyId);
      ((GalleryReportedUtils.ReportData)localObject).h = localJSONObject.toString();
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
        ((GalleryReportedUtils.ReportData)localObject).b = String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.c.a);
      }
      ((GalleryReportedUtils.ReportData)localObject).c = "0X8009A79";
      ((GalleryReportedUtils.ReportData)localObject).d = "0X8009A79";
      GalleryReportedUtils.a((GalleryReportedUtils.ReportData)localObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.d());
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("kandian_mode", RIJAppSetting.b());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(RIJFeedsType.g(paramAbsBaseArticleInfo));
      localJSONObject.put("feeds_type", ((StringBuilder)localObject).toString());
      localJSONObject.put("rowkey", ReadinjoyReportUtils.c(paramAbsBaseArticleInfo));
      paramAbsBaseArticleInfo = localJSONObject.toString();
      PublicAccountReportUtils.a(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", HardCodeUtil.a(2131910628), paramAbsBaseArticleInfo, false);
      return;
    }
    catch (Exception paramAbsBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.4
 * JD-Core Version:    0.7.0.1
 */