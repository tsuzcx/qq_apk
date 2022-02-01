package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/RIJFrameworkReportManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IRIJFrameworkReportManager;", "()V", "makeGridImageReadArticleReport", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "source", "", "index", "", "bundle", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFrameworkReportManagerImpl
  implements IRIJFrameworkReportManager
{
  public void makeGridImageReadArticleReport(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable String paramString, int paramInt, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    long l2 = paramAbsBaseArticleInfo.mFeedId;
    int i = paramInt + 1;
    String str1;
    long l1;
    if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
    {
      str1 = paramAbsBaseArticleInfo.mSubscribeID;
      l1 = paramAbsBaseArticleInfo.mArticleID;
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null))
      {
        paramInt = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size();
        break label196;
      }
    }
    else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null))
    {
      str1 = Long.toString(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramInt = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size();
        l1 = 0L;
        break label196;
      }
      l1 = 0L;
    }
    else
    {
      l1 = 0L;
      str1 = "";
    }
    paramInt = 0;
    label196:
    paramString = RIJTransMergeKanDianReport.a(paramInt, i, paramString, RIJFeedsType.a(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo.innerUniqueID, paramAbsBaseArticleInfo);
    String str2 = RIJTransMergeKanDianReport.a(paramInt, i, null, RIJFeedsType.a(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.c(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
    paramBundle.putString("to_uin", str1);
    paramBundle.putString("feeds_id", Long.toString(l2));
    paramBundle.putString("article_id", Long.toString(l1));
    paramBundle.putInt("position", i);
    paramBundle.putString("read_article_r5", paramString);
    paramBundle.putString("scroll_image_r5", str2);
    paramBundle.putLong("channel_id", paramAbsBaseArticleInfo.mChannelID);
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(paramAbsBaseArticleInfo.mStrategyId);
    paramBundle.putString("strategy_id", paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.impl.RIJFrameworkReportManagerImpl
 * JD-Core Version:    0.7.0.1
 */