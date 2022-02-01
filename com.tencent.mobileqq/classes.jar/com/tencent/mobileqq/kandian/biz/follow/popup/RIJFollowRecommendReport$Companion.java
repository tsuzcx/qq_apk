package com.tencent.mobileqq.kandian.biz.follow.popup;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJFollowRecommendReport$Companion;", "", "()V", "ACTION_NAME_RECOMMEND_CARD_EXPOSE", "", "ACTION_NAME_RECOMMEND_DIALOG_CLOSE", "AVATOR_CLICK", "CARD_CLICK", "FOLLOW_BUTTON_CLICK", "KEY_ACC_REC_LOCATION", "KEY_APP_TYPE", "KEY_BUTTON_TYPE", "KEY_CLICK_TYPE", "KEY_CLOSE_WAY", "KEY_PUIN", "KEY_SCENE_TYPE", "KEY_TRIGGER_TYPE", "KEY_UGC_UIN", "KEY_UIN", "TAG", "getBaseR5Builder", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "source", "", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "reportData", "", "actionName", "r5", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFollowRecommendReport$Companion
{
  @NotNull
  public final RIJTransMergeKanDianReport.ReportR5Builder a(@Nullable Integer paramInteger)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
    int i = 2;
    int j;
    if ((paramInteger != null) && (paramInteger.intValue() == 2))
    {
      i = 4;
      j = 3;
    }
    else
    {
      j = 2;
    }
    localReportR5Builder.addStringNotThrow("uin", RIJQQAppInterfaceUtil.a());
    localReportR5Builder.addStringNotThrow("acc_rec_location", i);
    localReportR5Builder.addStringNotThrow("trigger_type", 1);
    localReportR5Builder.addStringNotThrow("scene_type", j);
    localReportR5Builder.addStringNotThrow("app_type", 1);
    Intrinsics.checkExpressionValueIsNotNull(localReportR5Builder, "r5Builder");
    return localReportR5Builder;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "actionName");
    Intrinsics.checkParameterIsNotNull(paramString2, "r5");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportData] actionName = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", r5 = ");
    localStringBuilder.append(paramString2);
    QLog.i("RIJFollowRecommendReportUtil", 1, localStringBuilder.toString());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowRecommendReport.Companion
 * JD-Core Version:    0.7.0.1
 */