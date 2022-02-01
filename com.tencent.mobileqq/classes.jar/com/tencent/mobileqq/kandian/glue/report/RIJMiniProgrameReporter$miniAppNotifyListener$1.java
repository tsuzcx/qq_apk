package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "appid", "", "kotlin.jvm.PlatformType", "scene", "", "via", "event", "timestamp", "", "onNotify"}, k=3, mv={1, 1, 16})
final class RIJMiniProgrameReporter$miniAppNotifyListener$1
  implements MiniAppNotify.IMiniAppNotifyListener
{
  public static final 1 a = new 1();
  
  public final void onNotify(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appid: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" scene: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" via: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" event: ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" timestamp: ");
    localStringBuilder.append(paramLong);
    QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
    if (paramInt != 2103) {
      return;
    }
    RIJMiniProgrameReporter.a.e(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJMiniProgrameReporter.miniAppNotifyListener.1
 * JD-Core Version:    0.7.0.1
 */