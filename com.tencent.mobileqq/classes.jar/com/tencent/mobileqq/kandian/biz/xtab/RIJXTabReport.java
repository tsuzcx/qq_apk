package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabReport;", "", "()V", "TAG", "", "reportXTabTopicBtn", "", "isDynamicIcon", "", "actionName", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabReport
{
  public static final RIJXTabReport a = new RIJXTabReport();
  
  @JvmStatic
  public static final void a(boolean paramBoolean, @Nullable String paramString)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a().addTime().addKandianModeNew();
    String str1;
    if (paramBoolean) {
      str1 = "1";
    }
    for (;;)
    {
      try
      {
        localReportR5Builder.addString("is_dynamic", str1);
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exposure topic btn has error : ");
        localStringBuilder.append(localJSONException);
        QLog.d("RIJXTabReport", 2, localStringBuilder.toString());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", localReportR5Builder.build(), false);
      return;
      String str2 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabReport
 * JD-Core Version:    0.7.0.1
 */