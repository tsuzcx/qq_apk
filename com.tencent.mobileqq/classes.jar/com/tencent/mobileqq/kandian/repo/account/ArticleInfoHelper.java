package com.tencent.mobileqq.kandian.repo.account;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;

public class ArticleInfoHelper
{
  public static long a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return 0L;
      }
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.a != null)
      {
        l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.a.a;
        if (l1 != 0L) {
          return l1;
        }
      }
      try
      {
        l2 = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
        return l2;
      }
      catch (NumberFormatException paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
        l2 = l1;
      }
    }
    return l2;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a()))
    {
      if (RIJItemViewTypeUtils.e(paramAbsBaseArticleInfo)) {
        return true;
      }
      return b(paramAbsBaseArticleInfo) ^ true;
    }
    return false;
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return a(paramAbsBaseArticleInfo) == RIJQQAppInterfaceUtil.a();
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return false;
      }
      if (!paramAbsBaseArticleInfo.mSocialFeedInfo.a()) {
        return false;
      }
      bool1 = bool2;
      if (!RIJItemViewTypeUtils.e(paramAbsBaseArticleInfo))
      {
        bool1 = bool2;
        if (!b(paramAbsBaseArticleInfo)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper
 * JD-Core Version:    0.7.0.1
 */