package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJReportDataCollectionManager;
import com.tencent.mobileqq.kandian.glue.report.RIJMiniProgrameReporter;
import com.tencent.mobileqq.kandian.repo.db.struct.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/RIJMiniProgramUtils;", "", "()V", "TAG", "", "clickMiniProgrameCard", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "fromPage", "", "schema", "get64eReportData", "Lcom/tencent/mobileqq/kandian/repo/report/BaseReportData;", "report64e", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJMiniProgramUtils
{
  public static final RIJMiniProgramUtils a = new RIJMiniProgramUtils();
  private static final String b = "RIJMiniProgramUtils";
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report64e: ");
    Object localObject2 = null;
    if (paramAbsBaseArticleInfo != null) {
      localObject1 = paramAbsBaseArticleInfo.miniProgramName;
    } else {
      localObject1 = null;
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", ");
    Object localObject1 = localObject2;
    if (paramAbsBaseArticleInfo != null) {
      localObject1 = paramAbsBaseArticleInfo.miniAppMovieName;
    }
    localStringBuilder.append((String)localObject1);
    QLog.d(str, 1, localStringBuilder.toString());
    paramAbsBaseArticleInfo = b(paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo != null) {
      RIJReportDataCollectionManager.a(paramAbsBaseArticleInfo, 0, 60);
    }
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, @Nullable String paramString)
  {
    Object localObject1 = null;
    if (paramString == null) {
      if (paramAbsBaseArticleInfo != null) {
        paramString = paramAbsBaseArticleInfo.mArticleContentUrl;
      } else {
        paramString = null;
      }
    }
    if (paramString != null)
    {
      Object localObject2 = (Context)BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&appscene=");
      localStringBuilder.append(2103);
      ReadInJoyUtils.b((Context)localObject2, localStringBuilder.toString());
      localObject2 = RIJMiniProgrameReporter.a;
      if (paramAbsBaseArticleInfo != null) {
        paramString = paramAbsBaseArticleInfo.miniProgramName;
      } else {
        paramString = null;
      }
      ((RIJMiniProgrameReporter)localObject2).a(paramString);
      localObject2 = RIJMiniProgrameReporter.a;
      if (paramAbsBaseArticleInfo != null) {
        paramString = paramAbsBaseArticleInfo.miniAppMovieName;
      } else {
        paramString = null;
      }
      ((RIJMiniProgrameReporter)localObject2).b(paramString);
      localObject2 = RIJMiniProgrameReporter.a;
      if (paramAbsBaseArticleInfo != null) {
        paramString = paramAbsBaseArticleInfo.miniRowKey;
      } else {
        paramString = null;
      }
      ((RIJMiniProgrameReporter)localObject2).c(paramString);
      RIJMiniProgrameReporter.a.a(paramInt);
      localObject2 = RIJMiniProgrameReporter.a;
      paramString = localObject1;
      if (paramAbsBaseArticleInfo != null) {
        paramString = paramAbsBaseArticleInfo.getSubscribeUin();
      }
      ((RIJMiniProgrameReporter)localObject2).d(paramString);
      a(paramAbsBaseArticleInfo);
    }
  }
  
  @Nullable
  public final BaseReportData b(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      ReportData localReportData = new ReportData();
      localReportData.m = paramAbsBaseArticleInfo;
      localReportData.g = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
      localReportData.i = paramAbsBaseArticleInfo.mAlgorithmID;
      localReportData.h = paramAbsBaseArticleInfo.mStrategyId;
      localReportData.t = paramAbsBaseArticleInfo.miniRowKey;
      return (BaseReportData)localReportData;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJMiniProgramUtils
 * JD-Core Version:    0.7.0.1
 */