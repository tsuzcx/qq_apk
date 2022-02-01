package com.tencent.mobileqq.kandian.glue.report.dt;

import android.app.Activity;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/dt/RIJDtReportHelper;", "", "()V", "configPageParamsWithoutParams", "", "activity", "Landroid/app/Activity;", "pageID", "", "reportCardClickEvent", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJDtReportHelper
{
  public static final RIJDtReportHelper a = new RIJDtReportHelper();
  
  @JvmOverloads
  public final void a(@Nullable Activity paramActivity)
  {
    a(this, paramActivity, null, 2, null);
  }
  
  @JvmOverloads
  public final void a(@Nullable Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pageID");
    if (paramActivity == null) {
      return;
    }
    VideoReport.addToDetectionWhitelist(paramActivity);
    VideoReport.setPageId(paramActivity, paramString);
    VideoReport.setPageParams(paramActivity, new RIJDtParamBuilder().b());
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder();
    Object localObject2 = null;
    if (paramAbsBaseArticleInfo != null) {
      localObject1 = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      localObject1 = null;
    }
    localRIJDtParamBuilder = RIJDtParamBuilder.a(localRIJDtParamBuilder.e((String)localObject1).a("14"), null, 1, null).b("list");
    if (paramAbsBaseArticleInfo != null) {
      localObject1 = Long.valueOf(paramAbsBaseArticleInfo.mChannelID);
    } else {
      localObject1 = Integer.valueOf(0);
    }
    localRIJDtParamBuilder = localRIJDtParamBuilder.a((Number)localObject1).c("click_contentid");
    Object localObject1 = localObject2;
    if (paramAbsBaseArticleInfo != null) {
      localObject1 = paramAbsBaseArticleInfo.dtReportBackendInfo;
    }
    localObject1 = localRIJDtParamBuilder.g((String)localObject1);
    int i;
    if (paramAbsBaseArticleInfo != null) {
      i = paramAbsBaseArticleInfo.dtReportContentType;
    } else {
      i = 5;
    }
    VideoReport.reportEvent("clck", ((RIJDtParamBuilder)localObject1).b((Number)Integer.valueOf(i)).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper
 * JD-Core Version:    0.7.0.1
 */