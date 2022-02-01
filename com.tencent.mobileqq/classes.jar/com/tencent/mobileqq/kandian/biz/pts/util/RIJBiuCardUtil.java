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
  private static PGCPicInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size() > 0)) {
      return (PGCPicInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.get(0);
    }
    return null;
  }
  
  private static Boolean a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a;
    boolean bool = false;
    localObject = (UGCPicInfo)((ArrayList)localObject).get(0);
    if ((localObject != null) && (((UGCPicInfo)localObject).b > 0))
    {
      float f = ((UGCPicInfo)localObject).jdField_a_of_type_Int / ((UGCPicInfo)localObject).b;
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityIconWordingInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityIconWordingInfo.c == 1))
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
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType != 1) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo == null) {
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
      if (g(paramAbsBaseArticleInfo)) {
        return true;
      }
      if (h(paramAbsBaseArticleInfo)) {
        return true;
      }
      if (i(paramAbsBaseArticleInfo)) {
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
    return (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 2) && (k(paramAbsBaseArticleInfo));
  }
  
  private static boolean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5) || (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 6))
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
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9)
    {
      if (RIJFeedsType.l(paramAbsBaseArticleInfo)) {
        return false;
      }
      if (j(paramAbsBaseArticleInfo))
      {
        if (paramAbsBaseArticleInfo.mChannelID == 0L) {
          return true;
        }
        paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo);
        if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.b > 0) && (paramAbsBaseArticleInfo.jdField_a_of_type_Int / paramAbsBaseArticleInfo.b < 1.671428571428572D)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (l(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a.size() == 1))
    {
      if (paramAbsBaseArticleInfo.mChannelID == 0L) {
        return true;
      }
      paramAbsBaseArticleInfo = (UGCPicInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a.get(0);
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.b != 0) && (paramAbsBaseArticleInfo.jdField_a_of_type_Int != 0) && (paramAbsBaseArticleInfo.jdField_a_of_type_Int / paramAbsBaseArticleInfo.b < 1.671428571428572D)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo) != 22) {
      return false;
    }
    if ((l(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a.size() == 1)) {
      return a(paramAbsBaseArticleInfo).booleanValue();
    }
    return false;
  }
  
  private static boolean i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo) == 23) && (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.size() > 0))
    {
      paramAbsBaseArticleInfo = (UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0);
      if (paramAbsBaseArticleInfo.d == 0) {
        paramAbsBaseArticleInfo.d = 1;
      }
      if (paramAbsBaseArticleInfo.c / paramAbsBaseArticleInfo.d < 0.75D) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean j(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size() == 1);
  }
  
  private static boolean k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.isPGCShortContent()) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size() > 0);
  }
  
  private static boolean l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJBiuCardUtil
 * JD-Core Version:    0.7.0.1
 */