package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/RIJViewInterceptor;", "", "onBindView", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "position", "", "shouldIntercept", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface RIJViewInterceptor
{
  public abstract void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt);
  
  public abstract boolean a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJViewInterceptor
 * JD-Core Version:    0.7.0.1
 */