package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusFamilyUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/ReadInJoyProteusFamilyUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyProteusFamilyUtil;", "()V", "checkPermission", "", "recordAdArticleInfo", "", "summary", "Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;", "adInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyProteusFamilyUtilImpl
  implements IReadInJoyProteusFamilyUtil
{
  public boolean checkPermission()
  {
    return ReadInJoyProteusFamilyUtil.a();
  }
  
  public void recordAdArticleInfo(@Nullable articlesummary.ArticleSummary paramArticleSummary, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ReadInJoyProteusFamilyUtil.a().a(paramArticleSummary, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.ReadInJoyProteusFamilyUtilImpl
 * JD-Core Version:    0.7.0.1
 */