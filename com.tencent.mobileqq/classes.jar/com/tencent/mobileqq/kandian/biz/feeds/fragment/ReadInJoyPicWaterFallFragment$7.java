package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import java.util.List;
import java.util.Map;

class ReadInJoyPicWaterFallFragment$7
  implements Runnable
{
  ReadInJoyPicWaterFallFragment$7(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    ReportData localReportData = new ReportData();
    localReportData.h = this.a.mStrategyId;
    localReportData.i = this.a.mAlgorithmID;
    if (!TextUtils.isEmpty(this.a.mVideoVid)) {
      localReportData.n = this.a.mVideoVid;
    }
    localReportData.j = RIJFeedsType.g(this.a);
    int i;
    if (this.a.hasChannelInfo()) {
      i = this.a.mChannelInfoId;
    } else {
      i = 0;
    }
    localReportData.o = i;
    localReportData.p = (TextUtils.isEmpty(this.a.mArticleFriendLikeText) ^ true);
    localReportData.q = this.a.mServerContext;
    localReportData.k = RIJFeedsType.k(this.a);
    Object localObject = this.a;
    localReportData.l = ((AbsBaseArticleInfo)localObject);
    localReportData.m = ((AbsBaseArticleInfo)localObject);
    boolean bool;
    if ((((AbsBaseArticleInfo)localObject).mGroupId == -1L) && (!this.a.isSubscriptFeed())) {
      bool = false;
    } else {
      bool = true;
    }
    localReportData.c = bool;
    if (((RIJItemViewTypeUtils.m(this.a)) || (RIJItemViewTypeUtils.l(this.a)) || (RIJItemViewTypeUtils.n(this.a)) || (RIJItemViewTypeUtils.p(this.a))) && (!RIJItemViewTypeUtils.v(this.a)))
    {
      localReportData.s = String.valueOf(this.a.mSocialFeedInfo.s.e);
      localReportData.g = Long.valueOf(this.a.businessId);
    }
    else if ((RIJFeedsType.F(this.a)) && (this.a.mPolymericInfo.e == 6))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.mPolymericInfo.f);
      ((StringBuilder)localObject).append("");
      localReportData.s = ((StringBuilder)localObject).toString();
      localReportData.g = Long.valueOf(this.a.mArticleID);
    }
    else if (RIJFeedsType.I(this.a))
    {
      if (RIJFeedsType.G(this.a))
      {
        if (this.a.mGroupSubArticleList.size() >= 1)
        {
          if (!TextUtils.isEmpty(((AbsBaseArticleInfo)this.a.mGroupSubArticleList.get(0)).mVideoVid)) {
            localReportData.n = ((AbsBaseArticleInfo)this.a.mGroupSubArticleList.get(0)).mVideoVid;
          }
          localReportData.t = ((AbsBaseArticleInfo)this.a.mGroupSubArticleList.get(0)).innerUniqueID;
        }
      }
      else {
        localReportData.B = this.b;
      }
      localReportData.g = Long.valueOf(this.a.mArticleID);
    }
    else if (RIJFeedsType.l(this.a))
    {
      localReportData.s = this.a.mSubscribeID;
      localReportData.g = Long.valueOf(this.a.mArticleID);
    }
    else
    {
      localReportData.s = this.a.mSubscribeID;
      localReportData.g = Long.valueOf(this.a.mArticleID);
    }
    localReportData.r = this.a.mStrCircleId;
    localReportData.t = this.a.innerUniqueID;
    localReportData.u = this.c;
    localReportData.v = RIJAppSetting.b();
    localReportData.z = this.a.mVideoAdsJumpType;
    localReportData.y = this.a.mVideoAdsSource;
    localReportData.A = this.d;
    localReportData.B = this.b;
    this.this$0.t.put(Long.valueOf(this.a.mArticleID), localReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.7
 * JD-Core Version:    0.7.0.1
 */