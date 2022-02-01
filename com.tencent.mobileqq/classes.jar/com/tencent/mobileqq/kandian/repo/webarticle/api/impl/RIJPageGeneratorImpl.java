package com.tencent.mobileqq.kandian.repo.webarticle.api.impl;

import com.tencent.mobileqq.kandian.repo.webarticle.RIJPageGenerator;
import com.tencent.mobileqq.kandian.repo.webarticle.api.IRIJPageGenerator;
import com.tencent.mobileqq.kandian.repo.webarticle.data.ArticleDetailInfo;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/api/impl/RIJPageGeneratorImpl;", "Lcom/tencent/mobileqq/kandian/repo/webarticle/api/IRIJPageGenerator;", "()V", "generatePageHtml", "", "articleDetail", "Lcom/tencent/mobileqq/kandian/repo/webarticle/data/ArticleDetailInfo;", "getPageHtmlFromUrl", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "url", "", "isHitCache", "", "rowKey", "isPageHtmlExist", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPageGeneratorImpl
  implements IRIJPageGenerator
{
  public void generatePageHtml(@NotNull ArticleDetailInfo paramArticleDetailInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleDetailInfo, "articleDetail");
    this.$$delegate_0.generatePageHtml(paramArticleDetailInfo);
  }
  
  @Nullable
  public WebResourceResponse getPageHtmlFromUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    return this.$$delegate_0.getPageHtmlFromUrl(paramString);
  }
  
  public boolean isHitCache(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    return this.$$delegate_0.isHitCache(paramString);
  }
  
  public boolean isPageHtmlExist(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    return this.$$delegate_0.isPageHtmlExist(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.api.impl.RIJPageGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */