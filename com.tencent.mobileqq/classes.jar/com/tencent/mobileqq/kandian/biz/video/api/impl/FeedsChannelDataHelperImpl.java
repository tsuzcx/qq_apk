package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.FeedsChannelDataHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IFeedsChannelDataHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/FeedsChannelDataHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IFeedsChannelDataHelper;", "()V", "getVideoInfoReq", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FeedsChannelDataHelperImpl
  implements IFeedsChannelDataHelper
{
  @NotNull
  public VideoInfo getVideoInfoReq(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    paramAbsBaseArticleInfo = FeedsChannelDataHelper.a(paramAbsBaseArticleInfo);
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "FeedsChannelDataHelper.g…VideoInfoReq(articleInfo)");
    return paramAbsBaseArticleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.FeedsChannelDataHelperImpl
 * JD-Core Version:    0.7.0.1
 */