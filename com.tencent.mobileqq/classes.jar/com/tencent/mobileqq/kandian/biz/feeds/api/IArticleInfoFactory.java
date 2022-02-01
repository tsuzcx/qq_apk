package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/IArticleInfoFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createBaseArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IArticleInfoFactory
  extends QRouteApi
{
  @NotNull
  public abstract AbsBaseArticleInfo createBaseArticleInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.IArticleInfoFactory
 * JD-Core Version:    0.7.0.1
 */