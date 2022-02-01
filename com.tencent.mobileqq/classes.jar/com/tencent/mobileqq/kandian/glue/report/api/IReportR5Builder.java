package com.tencent.mobileqq.kandian.glue.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/IReportR5Builder;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addStringNotThrow", "key", "", "value", "build", "create", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReportR5Builder
  extends QRouteApi
{
  @NotNull
  public abstract IReportR5Builder addStringNotThrow(@Nullable String paramString1, @Nullable String paramString2);
  
  @NotNull
  public abstract String build();
  
  @NotNull
  public abstract IReportR5Builder create();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.IReportR5Builder
 * JD-Core Version:    0.7.0.1
 */