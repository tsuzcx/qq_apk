package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import com.tencent.mobileqq.kandian.biz.framework.api.IRIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/RIJTransMergeKanDianReportImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IRIJTransMergeKanDianReport;", "()V", "bigTR5", "", "getKandianTabSource", "", "transGridImageClickR5", "picNumber", "picPosition", "source", "feedsType", "innerUniqueID", "feedsSource", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "transMergeKandianReportR5", "transMergeKandianReportR5WithTime", "algorithmId", "", "channelId", "channelEntranceId", "interactionType", "isWifi", "", "strCircleId", "innerUniqId", "accountType", "jumpToChannel", "alg", "id", "isSticky", "socialUin", "hasShownMergeAvatar", "transReadArticleClickR5", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJTransMergeKanDianReportImpl
  implements IRIJTransMergeKanDianReport
{
  @NotNull
  public String bigTR5()
  {
    String str = RIJTransMergeKanDianReport.a().addString("ad_mengceng", String.valueOf(1)).build();
    Intrinsics.checkExpressionValueIsNotNull(str, "RIJTransMergeKanDianRepo…CH, 1.toString()).build()");
    return str;
  }
  
  public int getKandianTabSource()
  {
    return RIJTransMergeKanDianReport.a();
  }
  
  @Nullable
  public String transGridImageClickR5(int paramInt1, int paramInt2, @Nullable String paramString1, int paramInt3, @Nullable String paramString2, @Nullable String paramString3, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJTransMergeKanDianReport.a(paramInt1, paramInt2, paramString1, paramInt3, paramString2, paramString3, paramAbsBaseArticleInfo);
  }
  
  @Nullable
  public String transMergeKandianReportR5()
  {
    return RIJTransMergeKanDianReport.a();
  }
  
  @Nullable
  public String transMergeKandianReportR5WithTime(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return RIJTransMergeKanDianReport.b(paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  @Nullable
  public String transMergeKandianReportR5WithTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, int paramInt5, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJTransMergeKanDianReport.a(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString1, paramString2, paramString3, paramString4, paramInt5, paramAbsBaseArticleInfo);
  }
  
  @Nullable
  public String transMergeKandianReportR5WithTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJTransMergeKanDianReport.a(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString1, paramString2, paramString3, paramString4, paramAbsBaseArticleInfo);
  }
  
  @Nullable
  public String transMergeKandianReportR5WithTime(@Nullable String paramString)
  {
    return RIJTransMergeKanDianReport.a(paramString);
  }
  
  @Nullable
  public String transMergeKandianReportR5WithTime(@Nullable String paramString1, @Nullable String paramString2)
  {
    return RIJTransMergeKanDianReport.a(paramString1, paramString2);
  }
  
  @Nullable
  public String transMergeKandianReportR5WithTime(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, boolean paramBoolean)
  {
    return RIJTransMergeKanDianReport.a(paramString1, paramString2, paramString3, paramString4, paramBoolean);
  }
  
  @Nullable
  public String transReadArticleClickR5(int paramInt1, int paramInt2, @Nullable String paramString1, int paramInt3, @Nullable String paramString2, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJTransMergeKanDianReport.a(paramInt1, paramInt2, paramString1, paramInt3, paramString2, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.impl.RIJTransMergeKanDianReportImpl
 * JD-Core Version:    0.7.0.1
 */