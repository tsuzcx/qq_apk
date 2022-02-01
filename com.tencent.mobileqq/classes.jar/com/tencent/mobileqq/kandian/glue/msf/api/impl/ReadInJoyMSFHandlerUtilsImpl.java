package com.tencent.mobileqq.kandian.glue.msf.api.impl;

import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/impl/ReadInJoyMSFHandlerUtilsImpl;", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyMSFHandlerUtils;", "()V", "convertArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "summary", "Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;", "channelID", "", "refreshType", "articleInfo", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyMSFHandlerUtilsImpl
  implements IReadInJoyMSFHandlerUtils
{
  @Nullable
  public AbsBaseArticleInfo convertArticleInfo(@Nullable articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyMSFHandlerUtils.a(paramArticleSummary, paramInt1, paramInt2, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.impl.ReadInJoyMSFHandlerUtilsImpl
 * JD-Core Version:    0.7.0.1
 */