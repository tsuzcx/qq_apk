package com.tencent.mobileqq.kandian.repo.webarticle.api.impl;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.DataPreloadModule;
import com.tencent.mobileqq.kandian.repo.webarticle.api.IDataPreloadModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/api/impl/DataPreloadModuleImpl;", "Lcom/tencent/mobileqq/kandian/repo/webarticle/api/IDataPreloadModule;", "()V", "preloadArticle", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "requestArticleDetailInWebProcess", "rowKey", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataPreloadModuleImpl
  implements IDataPreloadModule
{
  public void preloadArticle(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    this.$$delegate_0.preloadArticle(paramAbsBaseArticleInfo);
  }
  
  public void requestArticleDetailInWebProcess(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    this.$$delegate_0.requestArticleDetailInWebProcess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.api.impl.DataPreloadModuleImpl
 * JD-Core Version:    0.7.0.1
 */