package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class OnTopicRecommendHeaderFollowClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private Context b;
  private ActionSheet c;
  private TopicRecommendFeedsInfo.TopicRecommendInfo d;
  
  public OnTopicRecommendHeaderFollowClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
    a(paramAbsBaseArticleInfo);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (this.a.mTopicRecommendFeedsInfo != null) && (this.a.mTopicRecommendFeedsInfo.g != null) && (this.a.mTopicRecommendFeedsInfo.g.size() > 0)) {
      this.d = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.a.mTopicRecommendFeedsInfo.g.get(0));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = ReadInJoyUtils.b();
    if (this.d != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("before request0x978 articleInfo articleID = ，isfollow = ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(" businessId = ");
        localStringBuilder.append(this.d.a);
        QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, localStringBuilder.toString());
      }
      if (paramBoolean)
      {
        ReadInJoyLogicEngine.a().c().request0x978((String)localObject, Long.toString(this.d.a), true, "", new OnTopicRecommendHeaderFollowClickListener.3(this, paramBoolean), 3);
        return;
      }
      ReadInJoyLogicEngine.a().c().request0x978((String)localObject, Long.toString(this.d.a), false, "", new OnTopicRecommendHeaderFollowClickListener.4(this, paramBoolean), 3);
    }
  }
  
  private void b()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return;
    }
    if (((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).g == 1)
    {
      if (RIJFeedsType.S(this.a)) {
        return;
      }
      a();
      return;
    }
    a(true);
    Object localObject2;
    if (!RIJFeedsType.S(this.a))
    {
      localObject1 = RIJFeedsType.k(this.a);
      long l = this.a.mAlgorithmID;
      int i = RIJFeedsType.g(this.a);
      int j = (int)this.a.mChannelID;
      boolean bool = NetworkUtil.isWifiConnected(this.b);
      localObject2 = this.a.innerUniqueID;
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.businessId);
      localStringBuilder.append("");
      localObject2 = RIJTransMergeKanDianReport.a(l, i, j, bool, (String)localObject1, (String)localObject2, localAbsBaseArticleInfo, localStringBuilder.toString());
      PublicAccountReportUtils.a(null, (String)localObject1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.a.mFeedId), Long.toString(this.a.mArticleID), Long.toString(this.a.mAlgorithmID), (String)localObject2, false);
    }
    else
    {
      if (ReadinjoyReportUtils.d(this.a.mChannelID)) {
        localObject1 = "0X800941D";
      } else {
        localObject1 = "0X80080EC";
      }
      localObject2 = this.a;
      RIJFrameworkReportManager.a((AbsBaseArticleInfo)localObject2, (String)localObject1, (String)localObject1, (int)((AbsBaseArticleInfo)localObject2).mChannelID);
      ReadInJoyLogicEngine.e(this.a);
    }
    localObject1 = this.a;
    RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
  }
  
  protected void a()
  {
    this.c = ((ActionSheet)ActionSheetHelper.b(this.b, null));
    this.c.addButton(2131893006, 3);
    this.c.addCancelButton(2131887648);
    this.c.setOnDismissListener(new OnTopicRecommendHeaderFollowClickListener.1(this));
    this.c.setOnButtonClickListener(new OnTopicRecommendHeaderFollowClickListener.2(this));
    if (!this.c.isShowing()) {
      this.c.show();
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicRecommendHeaderFollowClickListener
 * JD-Core Version:    0.7.0.1
 */