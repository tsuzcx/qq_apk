package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.SimpleFeedbackPopupWindow;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils.ReportData;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import org.json.JSONObject;

class ReadInJoyPicWaterFallFragment$NormalViewHolder$2
  implements View.OnClickListener
{
  ReadInJoyPicWaterFallFragment$NormalViewHolder$2(ReadInJoyPicWaterFallFragment.NormalViewHolder paramNormalViewHolder, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPicWaterFallFragment.d(this.b.r).a(paramView, this.b.g, this.b.a());
    paramView = GalleryReportedUtils.a(this.b.d, this.b.r.d(), 3, this.b.a(), this.b.g);
    try
    {
      paramView.put("card_type", 8);
      GalleryReportedUtils.ReportData localReportData = new GalleryReportedUtils.ReportData(this.b.g);
      localReportData.f = String.valueOf(this.b.g.mArticleID);
      localReportData.g = String.valueOf(this.b.g.mStrategyId);
      localReportData.h = paramView.toString();
      if (this.b.g.mSocialFeedInfo.c != null) {
        localReportData.b = String.valueOf(this.b.g.mSocialFeedInfo.c.a);
      }
      localReportData.c = "0X8009A78";
      localReportData.d = "0X8009A78";
      GalleryReportedUtils.a(localReportData);
      paramView = new JSONObject();
      paramView.put("time", System.currentTimeMillis() / 1000L);
      paramView.put("channel_id", this.b.r.d());
      paramView.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      paramView.put("kandian_mode", RIJAppSetting.b());
      paramView.put("feeds_type", "1008");
      paramView.put("rowkey", ReadinjoyReportUtils.c(this.b.g));
      PublicAccountReportUtils.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.NormalViewHolder.2
 * JD-Core Version:    0.7.0.1
 */