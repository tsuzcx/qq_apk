package com.tencent.mobileqq.kandian.repo.webarticle.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/api/IDataPreloadModule;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "preloadArticle", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "requestArticleDetailInWebProcess", "rowKey", "", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IDataPreloadModule
  extends QRouteApi
{
  @NotNull
  public static final String ATTRIBUTE_KEY_ROW_KEY = "attribute_key_rowKey";
  public static final IDataPreloadModule.Companion Companion = IDataPreloadModule.Companion.a;
  
  public abstract void preloadArticle(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void requestArticleDetailInWebProcess(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.api.IDataPreloadModule
 * JD-Core Version:    0.7.0.1
 */