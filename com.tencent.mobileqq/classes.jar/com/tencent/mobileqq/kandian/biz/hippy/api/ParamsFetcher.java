package com.tencent.mobileqq.kandian.biz.hippy.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/hippy/api/ParamsFetcher;", "", "onGetParams", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "adTag", "", "biuType", "sourceUrl", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ParamsFetcher
{
  public abstract void onGetParams(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, @NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.api.ParamsFetcher
 * JD-Core Version:    0.7.0.1
 */