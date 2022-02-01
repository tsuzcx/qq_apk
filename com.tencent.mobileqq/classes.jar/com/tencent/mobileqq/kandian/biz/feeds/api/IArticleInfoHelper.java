package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/IArticleInfoHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isBaseArticleInfo", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "", "makeDislikeParam", "Lcom/tencent/mobileqq/kandian/repo/dislike/DislikeParam;", "dislikeInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/dislike/DislikeInfo;", "rowkey", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IArticleInfoHelper
  extends QRouteApi
{
  public abstract boolean isBaseArticleInfo(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isBaseArticleInfo(@Nullable Object paramObject);
  
  @Nullable
  public abstract DislikeParam makeDislikeParam(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ArrayList<DislikeInfo> paramArrayList, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.IArticleInfoHelper
 * JD-Core Version:    0.7.0.1
 */