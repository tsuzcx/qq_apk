package com.tencent.mobileqq.kandian.biz.framework.api;

import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyBaseAdapterUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getBaseItemViewType", "", "article", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "channelType", "innerCreateVideoPlayParam", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/entity/VideoPlayParam;", "kandian-api_release"}, k=1, mv={1, 1, 16})
@IgnoreDenyDependencyToSelf
public abstract interface IReadInJoyBaseAdapterUtil
  extends QRouteApi
{
  public abstract int getBaseItemViewType(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt);
  
  @Nullable
  public abstract VideoPlayParam innerCreateVideoPlayParam(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyBaseAdapterUtil
 * JD-Core Version:    0.7.0.1
 */