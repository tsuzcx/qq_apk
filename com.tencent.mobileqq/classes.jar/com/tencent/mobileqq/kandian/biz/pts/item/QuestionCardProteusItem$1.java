package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSuperTopicClickListener;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.NetworkUtil;

class QuestionCardProteusItem$1
  implements View.OnClickListener
{
  QuestionCardProteusItem$1(QuestionCardProteusItem paramQuestionCardProteusItem, IReadInJoyModel paramIReadInJoyModel, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    OnSuperTopicClickListener.a(this.a.k(), this.b);
    paramView = this.a.k();
    String str1 = String.valueOf(RIJItemViewTypeUtils.a(this.a.k(), this.c));
    String str2 = RIJTransMergeKanDianReport.a(paramView.mAlgorithmID, RIJFeedsType.g(paramView), 70, 0, 0, NetworkUtil.isWifiConnected(this.b), str1, null, paramView.innerUniqueID, null, paramView);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramView.mFeedId);
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, str1, "0X8009355", "0X8009355", 0, 0, localStringBuilder.toString(), String.valueOf(paramView.businessId), String.valueOf(paramView.mAlgorithmID), str2, false);
    ReadinjoyReportUtils.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.QuestionCardProteusItem.1
 * JD-Core Version:    0.7.0.1
 */