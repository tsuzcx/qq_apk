package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import com.tencent.mobileqq.kandian.biz.framework.RIJFeedsFluencyOptimizeUtil;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapterUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyBaseAdapterUtil;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/ReadInJoyBaseAdapterUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyBaseAdapterUtil;", "()V", "getBaseItemViewType", "", "article", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "channelType", "innerCreateVideoPlayParam", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/entity/VideoPlayParam;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyBaseAdapterUtilImpl
  implements IReadInJoyBaseAdapterUtil
{
  public int getBaseItemViewType(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    paramInt = ReadInJoyBaseAdapterUtil.a.a(paramAbsBaseArticleInfo, paramInt, RIJFeedsFluencyOptimizeUtil.a.a());
    RIJFeedsFluencyOptimizeUtil.a.a(paramAbsBaseArticleInfo, paramInt);
    return paramInt;
  }
  
  @Nullable
  public VideoPlayParam innerCreateVideoPlayParam(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyBaseAdapter.a(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyBaseAdapterUtilImpl
 * JD-Core Version:    0.7.0.1
 */