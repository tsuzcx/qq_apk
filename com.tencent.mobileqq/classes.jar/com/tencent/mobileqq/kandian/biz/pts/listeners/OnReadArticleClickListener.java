package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class OnReadArticleClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private Context b;
  private ReadInJoyBaseAdapter c;
  
  public OnReadArticleClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
    this.c = paramReadInJoyBaseAdapter;
  }
  
  private void a()
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      QLog.d("OnReadArticleClickListener", 2, "jumpToArticle. ");
      int i = RIJBaseItemViewType.c(this.a);
      Object localObject1;
      Object localObject2;
      if ((35 != i) && (34 != i) && (85 != i))
      {
        if (RIJFeedsType.y(this.a))
        {
          OnSuperTopicClickListener.a(this.a, this.b);
          localObject1 = this.a;
          RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
          c();
          return;
        }
        if (RIJFeedsType.z(this.a))
        {
          localObject1 = this.a.mSocialFeedInfo.x.i;
          RIJJumpUtils.a(this.b, (String)localObject1, null);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("click readArticle answerUrl +");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("OnReadArticleClickListener", 2, ((StringBuilder)localObject2).toString());
          localObject1 = this.a;
          RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
          c();
          return;
        }
        if (RIJItemViewTypeUtils.m(this.a))
        {
          RIJJumpUtils.a(this.b, this.a, 4, false, 7, false);
          localObject1 = this.a;
          RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject1, ((AbsBaseArticleInfo)localObject1).mChannelInfoId);
          return;
        }
        if (RIJItemViewTypeUtils.l(this.a))
        {
          RIJJumpUtils.a(this.b, this.a, 2, false, 6, false);
          localObject1 = this.a;
          RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
          return;
        }
        if ((RIJItemViewTypeUtils.s(this.a)) && (!RIJItemViewTypeUtils.z(this.a)))
        {
          localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.a.mSocialFeedInfo.v.g.get(0)).c;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ReadInJoyUtils.a(this.b, (String)localObject1);
          }
          localObject1 = this.b;
          localObject2 = this.a;
          RIJJumpUtils.a((Context)localObject1, (AbsBaseArticleInfo)localObject2, this.c, (int)((AbsBaseArticleInfo)localObject2).mChannelID);
        }
      }
      else
      {
        if (!TextUtils.isEmpty(this.a.mArticleContentUrl)) {
          if (RIJFeedsType.a(this.a.mArticleContentUrl, this.a.mChannelID, this.a)) {
            a(this.a);
          } else {
            ReadInJoyUtils.a(this.b, this.a.mArticleContentUrl);
          }
        }
        b();
        if ((RIJFeedsType.p(this.a)) || (RIJFeedsType.q(this.a)))
        {
          localObject1 = RIJFeedsType.k(this.a);
          localObject2 = Long.toString(this.a.mFeedId);
          String str1 = Long.toString(this.a.mArticleID);
          String str2 = Integer.toString(this.a.mStrategyId);
          String str3 = this.a.innerUniqueID;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a.businessId);
          localStringBuilder.append("");
          PublicAccountReportUtils.a(null, (String)localObject1, "0X8008A62", "0X8008A62", 0, 0, (String)localObject2, str1, str2, RIJTransMergeKanDianReport.a(str3, localStringBuilder.toString(), this.a), false);
        }
        c();
      }
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    ReadInJoyLogicEngine.a().d().a(paramAbsBaseArticleInfo.mArticleContentUrl, String.valueOf(paramAbsBaseArticleInfo.innerUniqueID), paramAbsBaseArticleInfo.mSubscribeID, 1, null);
    a(paramAbsBaseArticleInfo, null);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    RIJJumpUtils.a((Activity)this.b, paramAbsBaseArticleInfo);
  }
  
  private void b()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    if (localAbsBaseArticleInfo != null)
    {
      RIJFrameworkReportManager.a(localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
      return;
    }
    QLog.d("Q.readinjoy.ui", 1, "ComponentAccountSummary report click read article data, articleInfo is null!");
  }
  
  private void c()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    if (localAbsBaseArticleInfo != null) {
      ReadinjoyReportUtils.b(localAbsBaseArticleInfo);
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnReadArticleClickListener
 * JD-Core Version:    0.7.0.1
 */