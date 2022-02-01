package com.tencent.mobileqq.vas.adv.reward;

import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportRsp;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/reward/VasRewardAdBaseService$getReportAdRunnable$1$callback$1", "Lcom/tencent/mobileqq/vas/adv/base/VasAdvBizCallback;", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "onError", "", "code", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errMsg", "", "e", "", "onSucceed", "rsp", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdBaseService$getReportAdRunnable$1$callback$1
  implements VasAdvBizCallback<adv_report.MobileAdvReportRsp>
{
  public void a(@NotNull VasAdvServiceCode paramVasAdvServiceCode, @NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramVasAdvServiceCode, "code");
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    this.a.this$0.a(paramVasAdvServiceCode, paramString);
    VasRewardAdBaseService.c(this.a.this$0).set(false);
  }
  
  public void a(@NotNull adv_report.MobileAdvReportRsp paramMobileAdvReportRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramMobileAdvReportRsp, "rsp");
    this.a.this$0.a(paramMobileAdvReportRsp);
    VasRewardAdBaseService.c(this.a.this$0).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.VasRewardAdBaseService.getReportAdRunnable.1.callback.1
 * JD-Core Version:    0.7.0.1
 */