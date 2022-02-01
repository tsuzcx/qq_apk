package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyBaseAdapterUtil;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.mobileqq.qroute.QRoute;

public class RIJBaseItemViewType
{
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return a(paramAbsBaseArticleInfo, 0);
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    return ((IReadInJoyBaseAdapterUtil)QRoute.api(IReadInJoyBaseAdapterUtil.class)).getBaseItemViewType(paramAbsBaseArticleInfo, paramInt);
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    switch (a(paramAbsBaseArticleInfo))
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    int i = a(paramAbsBaseArticleInfo);
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    if ((i != 0) && (i != 1) && (i != 2) && (i != 60) && (i != 66) && (i != 104) && (i != 106) && (i != 115)) {
      switch (i)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && ("ReadInjoy_hot_news_account_cell".equals(PTSStyleManager.a(paramAbsBaseArticleInfo)));
  }
  
  public static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mChannelID == 0L) && ((RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.d(paramAbsBaseArticleInfo)) || (a(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.h(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.i(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.j(paramAbsBaseArticleInfo)));
  }
  
  public static boolean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.c == 0) && (a(paramAbsBaseArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType
 * JD-Core Version:    0.7.0.1
 */