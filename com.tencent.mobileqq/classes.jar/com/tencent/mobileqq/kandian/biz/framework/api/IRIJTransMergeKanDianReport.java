package com.tencent.mobileqq.kandian.biz.framework.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/IRIJTransMergeKanDianReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "bigTR5", "", "getKandianTabSource", "", "transGridImageClickR5", "picNumber", "picPosition", "source", "feedsType", "innerUniqueID", "feedsSource", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "transMergeKandianReportR5", "transMergeKandianReportR5WithTime", "algorithmId", "", "channelId", "channelEntranceId", "interactionType", "isWifi", "", "strCircleId", "innerUniqId", "accountType", "jumpToChannel", "alg", "id", "isSticky", "socialUin", "hasShownMergeAvatar", "transReadArticleClickR5", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJTransMergeKanDianReport
  extends QRouteApi
{
  @NotNull
  public abstract String bigTR5();
  
  public abstract int getKandianTabSource();
  
  @Nullable
  public abstract String transGridImageClickR5(int paramInt1, int paramInt2, @Nullable String paramString1, int paramInt3, @Nullable String paramString2, @Nullable String paramString3, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  @Nullable
  public abstract String transMergeKandianReportR5();
  
  @Nullable
  public abstract String transMergeKandianReportR5WithTime(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  @Nullable
  public abstract String transMergeKandianReportR5WithTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, int paramInt5, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  @Nullable
  public abstract String transMergeKandianReportR5WithTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  @Nullable
  public abstract String transMergeKandianReportR5WithTime(@Nullable String paramString);
  
  @Nullable
  public abstract String transMergeKandianReportR5WithTime(@Nullable String paramString1, @Nullable String paramString2);
  
  @Nullable
  public abstract String transMergeKandianReportR5WithTime(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, boolean paramBoolean);
  
  @Nullable
  public abstract String transReadArticleClickR5(int paramInt1, int paramInt2, @Nullable String paramString1, int paramInt3, @Nullable String paramString2, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.IRIJTransMergeKanDianReport
 * JD-Core Version:    0.7.0.1
 */