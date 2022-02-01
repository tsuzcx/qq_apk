package com.tencent.mobileqq.kandian.glue.report.api.impl;

import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.api.IReportR5Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/impl/ReportR5BuilderImpl;", "Lcom/tencent/mobileqq/kandian/glue/report/api/IReportR5Builder;", "()V", "reportR5Builder", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "getReportR5Builder", "()Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "setReportR5Builder", "(Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;)V", "addStringNotThrow", "key", "", "value", "build", "create", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReportR5BuilderImpl
  implements IReportR5Builder
{
  @NotNull
  private RIJTransMergeKanDianReport.ReportR5Builder reportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
  
  @NotNull
  public RIJTransMergeKanDianReport.ReportR5Builder addStringNotThrow(@Nullable String paramString1, @Nullable String paramString2)
  {
    paramString1 = this.reportR5Builder.addStringNotThrow(paramString1, paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "reportR5Builder.addStringNotThrow(key, value)");
    return paramString1;
  }
  
  @NotNull
  public String build()
  {
    String str = this.reportR5Builder.build();
    Intrinsics.checkExpressionValueIsNotNull(str, "reportR5Builder.build()");
    return str;
  }
  
  @NotNull
  public RIJTransMergeKanDianReport.ReportR5Builder create()
  {
    this.reportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    return this.reportR5Builder;
  }
  
  @NotNull
  public final RIJTransMergeKanDianReport.ReportR5Builder getReportR5Builder()
  {
    return this.reportR5Builder;
  }
  
  public final void setReportR5Builder(@NotNull RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    Intrinsics.checkParameterIsNotNull(paramReportR5Builder, "<set-?>");
    this.reportR5Builder = paramReportR5Builder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.impl.ReportR5BuilderImpl
 * JD-Core Version:    0.7.0.1
 */