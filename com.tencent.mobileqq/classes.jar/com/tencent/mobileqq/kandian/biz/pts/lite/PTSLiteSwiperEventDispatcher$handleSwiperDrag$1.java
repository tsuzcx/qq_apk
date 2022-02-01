package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSRijReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PTSLiteSwiperEventDispatcher$handleSwiperDrag$1
  implements Runnable
{
  PTSLiteSwiperEventDispatcher$handleSwiperDrag$1(String paramString, HashMap paramHashMap) {}
  
  public final void run()
  {
    if (TextUtils.isEmpty((CharSequence)this.a)) {
      QLog.i("PTSLiteSwiperEventDispatcher", 1, "[handleSwiperDrag] identifier is null.");
    }
    Object localObject = RIJTransMergeKanDianReport.g();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJTransMergeKanDianReport.baseR5Builder()");
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addString("type", "1");
    localObject = PTSRijReport.a(((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build(), this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleSwiperDrag], actionName = 0X800A5CC, r5 = ");
    localStringBuilder.append((String)localObject);
    QLog.i("PTSLiteSwiperEventDispatcher", 1, localStringBuilder.toString());
    PublicAccountReportUtils.a(null, "", "0X800A5CC", "0X800A5CC", 0, 0, "", "", "", (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteSwiperEventDispatcher.handleSwiperDrag.1
 * JD-Core Version:    0.7.0.1
 */