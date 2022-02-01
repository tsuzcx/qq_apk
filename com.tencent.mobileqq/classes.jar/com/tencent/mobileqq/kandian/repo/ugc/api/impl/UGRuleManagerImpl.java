package com.tencent.mobileqq.kandian.repo.ugc.api.impl;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.ugc.api.IUGRuleManager;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/ugc/api/impl/UGRuleManagerImpl;", "Lcom/tencent/mobileqq/kandian/repo/ugc/api/IUGRuleManager;", "()V", "getReportUrl", "", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isUgCard", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UGRuleManagerImpl
  implements IUGRuleManager
{
  @Nullable
  public List<String> getReportUrl(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return UGRuleManager.e(paramAbsBaseArticleInfo);
  }
  
  public boolean isUgCard(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return UGRuleManager.c(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.api.impl.UGRuleManagerImpl
 * JD-Core Version:    0.7.0.1
 */