package com.tencent.mobileqq.kandian.repo.webarticle.api;

import com.tencent.mobileqq.kandian.repo.webarticle.data.ArticleDetailInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/api/IRIJPageGenerator;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "generatePageHtml", "", "articleDetail", "Lcom/tencent/mobileqq/kandian/repo/webarticle/data/ArticleDetailInfo;", "getPageHtmlFromUrl", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "url", "", "isHitCache", "", "rowKey", "isPageHtmlExist", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJPageGenerator
  extends QRouteApi
{
  public abstract void generatePageHtml(@NotNull ArticleDetailInfo paramArticleDetailInfo);
  
  @Nullable
  public abstract WebResourceResponse getPageHtmlFromUrl(@NotNull String paramString);
  
  public abstract boolean isHitCache(@NotNull String paramString);
  
  public abstract boolean isPageHtmlExist(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.api.IRIJPageGenerator
 * JD-Core Version:    0.7.0.1
 */