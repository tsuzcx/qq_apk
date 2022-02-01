package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.IconWordingInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class RIJBiuCardUtil
{
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType != 1) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.n == null) {
      return false;
    }
    if (b(paramAbsBaseArticleInfo)) {
      return true;
    }
    return c(paramAbsBaseArticleInfo);
  }
  
  private static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo))
    {
      if (h(paramAbsBaseArticleInfo)) {
        return true;
      }
      if (i(paramAbsBaseArticleInfo)) {
        return true;
      }
      if (k(paramAbsBaseArticleInfo)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJItemViewTypeUtils.c(paramAbsBaseArticleInfo))
    {
      if (d(paramAbsBaseArticleInfo)) {
        return true;
      }
      if (e(paramAbsBaseArticleInfo)) {
        return true;
      }
      if (f(paramAbsBaseArticleInfo)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 2) && (m(paramAbsBaseArticleInfo));
  }
  
  private static boolean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo.b == 5) || (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 6))
    {
      int j = paramAbsBaseArticleInfo.mVideoJsonWidth;
      int i;
      if (paramAbsBaseArticleInfo.mVideoJsonHeight == 0) {
        i = 1;
      } else {
        i = paramAbsBaseArticleInfo.mVideoJsonHeight;
      }
      if (j / i < 0.75D) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 9)
    {
      if (RIJFeedsType.r(paramAbsBaseArticleInfo)) {
        return false;
      }
      if (l(paramAbsBaseArticleInfo))
      {
        if (paramAbsBaseArticleInfo.mChannelID == 0L) {
          return true;
        }
        paramAbsBaseArticleInfo = g(paramAbsBaseArticleInfo);
        if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.b > 0) && (paramAbsBaseArticleInfo.a / paramAbsBaseArticleInfo.b < 1.671428571428572D)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static PGCPicInfo g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.size() > 0)) {
      return (PGCPicInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.get(0);
    }
    return null;
  }
  
  private static boolean h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo.b == 9) && (n(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.size() == 1))
    {
      if (paramAbsBaseArticleInfo.mChannelID == 0L) {
        return true;
      }
      paramAbsBaseArticleInfo = (UGCPicInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.get(0);
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.b != 0) && (paramAbsBaseArticleInfo.a != 0) && (paramAbsBaseArticleInfo.a / paramAbsBaseArticleInfo.b < 1.671428571428572D)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJItemViewTypeUtils.A(paramAbsBaseArticleInfo) != 22) {
      return false;
    }
    if ((n(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.size() == 1)) {
      return j(paramAbsBaseArticleInfo).booleanValue();
    }
    return false;
  }
  
  private static Boolean j(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo.s.b;
    boolean bool = false;
    localObject = (UGCPicInfo)((ArrayList)localObject).get(0);
    if ((localObject != null) && (((UGCPicInfo)localObject).b > 0))
    {
      float f = ((UGCPicInfo)localObject).a / ((UGCPicInfo)localObject).b;
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo.z != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.z.g == 1))
      {
        if (f <= 1.3439D) {
          bool = true;
        }
        return Boolean.valueOf(bool);
      }
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  private static boolean k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((RIJItemViewTypeUtils.A(paramAbsBaseArticleInfo) == 23) && (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.c != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.c.size() > 0))
    {
      paramAbsBaseArticleInfo = (UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.s.c.get(0);
      if (paramAbsBaseArticleInfo.k == 0) {
        paramAbsBaseArticleInfo.k = 1;
      }
      if (paramAbsBaseArticleInfo.j / paramAbsBaseArticleInfo.k < 0.75D) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.size() == 1);
  }
  
  private static boolean m(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.isPGCShortContent()) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.size() > 0);
  }
  
  private static boolean n(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.b != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJBiuCardUtil
 * JD-Core Version:    0.7.0.1
 */