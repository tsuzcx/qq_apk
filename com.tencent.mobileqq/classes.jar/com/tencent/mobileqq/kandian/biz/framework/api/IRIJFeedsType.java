package com.tencent.mobileqq.kandian.biz.framework.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/IRIJFeedsType;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkArticleType", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getAccountType", "", "getArticleIdOrRowkey", "getMarkType", "info", "getSpecialFeedsSource", "isVideoArticle", "", "isVideoCard", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJFeedsType
  extends QRouteApi
{
  public abstract int checkArticleType(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  @NotNull
  public abstract String getAccountType(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  @Nullable
  public abstract String getArticleIdOrRowkey(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract int getMarkType(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  @NotNull
  public abstract String getSpecialFeedsSource(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isVideoArticle(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isVideoCard(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType
 * JD-Core Version:    0.7.0.1
 */