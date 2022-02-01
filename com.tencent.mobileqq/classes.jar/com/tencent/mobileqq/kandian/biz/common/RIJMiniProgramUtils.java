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
  public static final RIJMiniProgramUtils a;
  private static final String a = "RIJMiniProgramUtils";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJMiniProgramUtils = new RIJMiniProgramUtils();
    jdField_a_of_type_JavaLangString = "RIJMiniProgramUtils";
  }
  
  @Nullable
  public final BaseReportData a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      ReportData localReportData = new ReportData();
      localReportData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      localReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
      localReportData.jdField_a_of_type_Long = paramAbsBaseArticleInfo.mAlgorithmID;
      localReportData.jdField_b_of_type_Int = paramAbsBaseArticleInfo.mStrategyId;
      localReportData.e = paramAbsBaseArticleInfo.miniRowKey;
      return (BaseReportData)localReportData;
    }
    return null;
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = jdField_a_of_type_JavaLangString;
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
    paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJMiniProgramUtils
 * JD-Core Version:    0.7.0.1
 */