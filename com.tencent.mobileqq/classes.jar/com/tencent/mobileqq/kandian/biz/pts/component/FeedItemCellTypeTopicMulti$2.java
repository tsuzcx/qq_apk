package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendFeedsTitle;
import org.json.JSONException;
import org.json.JSONObject;

class FeedItemCellTypeTopicMulti$2
  implements View.OnClickListener
{
  FeedItemCellTypeTopicMulti$2(FeedItemCellTypeTopicMulti paramFeedItemCellTypeTopicMulti, AbsBaseArticleInfo paramAbsBaseArticleInfo, TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = this.a;
    ReadInJoyUtils.a(this.c.e, this.b.f.b);
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(RIJAppSetting.b());
      paramView.put("kandian_mode", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(RIJTransMergeKanDianReport.b());
      paramView.put("tab_source", localStringBuilder.toString());
      PublicAccountReportUtils.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicMulti.2
 * JD-Core Version:    0.7.0.1
 */