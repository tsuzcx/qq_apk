package com.tencent.mobileqq.kandian.biz.pts.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyProteusFamilyUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkPermission", "", "recordAdArticleInfo", "", "summary", "Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;", "adInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyProteusFamilyUtil
  extends QRouteApi
{
  public abstract boolean checkPermission();
  
  public abstract void recordAdArticleInfo(@Nullable articlesummary.ArticleSummary paramArticleSummary, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusFamilyUtil
 * JD-Core Version:    0.7.0.1
 */