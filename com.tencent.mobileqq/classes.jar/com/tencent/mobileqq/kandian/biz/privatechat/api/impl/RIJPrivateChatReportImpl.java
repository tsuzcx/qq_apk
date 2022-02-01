package com.tencent.mobileqq.kandian.biz.privatechat.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/privatechat/api/impl/RIJPrivateChatReportImpl;", "Lcom/tencent/mobileqq/kandian/biz/privatechat/api/IRIJPrivateChatReport;", "()V", "reportData", "", "actionName", "", "r5", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPrivateChatReportImpl
  implements IRIJPrivateChatReport
{
  public static final RIJPrivateChatReportImpl.Companion Companion = new RIJPrivateChatReportImpl.Companion(null);
  @NotNull
  public static final String TAG = "RIJPrivateChatReportImp";
  
  public void reportData(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "actionName");
    Intrinsics.checkParameterIsNotNull(paramString2, "r5");
    ThreadManager.getSubThreadHandler().post((Runnable)new RIJPrivateChatReportImpl.reportData.1(paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatReportImpl
 * JD-Core Version:    0.7.0.1
 */