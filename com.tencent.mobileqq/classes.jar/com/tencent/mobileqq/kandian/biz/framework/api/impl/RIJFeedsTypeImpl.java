package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/RIJFeedsTypeImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IRIJFeedsType;", "()V", "checkArticleType", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getAccountType", "", "getArticleIdOrRowkey", "getMarkType", "info", "getSpecialFeedsSource", "isVideoArticle", "", "isVideoCard", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsTypeImpl
  implements IRIJFeedsType
{
  public int checkArticleType(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    return RIJFeedsType.g(paramAbsBaseArticleInfo);
  }
  
  @NotNull
  public String getAccountType(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    paramAbsBaseArticleInfo = RIJFeedsType.n(paramAbsBaseArticleInfo);
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "RIJFeedsType.getAccountType(articleInfo)");
    return paramAbsBaseArticleInfo;
  }
  
  @Nullable
  public String getArticleIdOrRowkey(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJFeedsType.T(paramAbsBaseArticleInfo);
  }
  
  public int getMarkType(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJFeedsType.j(paramAbsBaseArticleInfo);
  }
  
  @NotNull
  public String getSpecialFeedsSource(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    paramAbsBaseArticleInfo = RIJFeedsType.k(paramAbsBaseArticleInfo);
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "RIJFeedsType.getSpecialFeedsSource(articleInfo)");
    return paramAbsBaseArticleInfo;
  }
  
  public boolean isVideoArticle(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    return RIJFeedsType.a(paramAbsBaseArticleInfo);
  }
  
  public boolean isVideoCard(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    return RIJFeedsType.U(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.impl.RIJFeedsTypeImpl
 * JD-Core Version:    0.7.0.1
 */