package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.feeds.api.IArticleInfoFactory;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/ArticleInfoFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IArticleInfoFactory;", "()V", "createBaseArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ArticleInfoFactoryImpl
  implements IArticleInfoFactory
{
  @NotNull
  public AbsBaseArticleInfo createBaseArticleInfo()
  {
    return (AbsBaseArticleInfo)new BaseArticleInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.ArticleInfoFactoryImpl
 * JD-Core Version:    0.7.0.1
 */