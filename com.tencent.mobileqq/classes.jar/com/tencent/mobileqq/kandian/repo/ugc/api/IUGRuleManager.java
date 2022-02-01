package com.tencent.mobileqq.kandian.repo.ugc.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/ugc/api/IUGRuleManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getReportUrl", "", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isUgCard", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IUGRuleManager
  extends QRouteApi
{
  @Nullable
  public abstract List<String> getReportUrl(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isUgCard(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.api.IUGRuleManager
 * JD-Core Version:    0.7.0.1
 */