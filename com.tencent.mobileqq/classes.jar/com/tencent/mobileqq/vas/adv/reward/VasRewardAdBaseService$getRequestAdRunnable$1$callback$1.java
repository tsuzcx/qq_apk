package com.tencent.mobileqq.vas.adv.reward;

import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvRsp;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/reward/VasRewardAdBaseService$getRequestAdRunnable$1$callback$1", "Lcom/tencent/mobileqq/vas/adv/base/VasAdvBizCallback;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "onError", "", "code", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errMsg", "", "e", "", "onSucceed", "rsp", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdBaseService$getRequestAdRunnable$1$callback$1
  implements VasAdvBizCallback<vac_adv_get.VacAdvRsp>
{
  public void a(@NotNull VasAdvServiceCode paramVasAdvServiceCode, @NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramVasAdvServiceCode, "code");
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    this.a.this$0.a(paramVasAdvServiceCode, paramString);
    VasRewardAdBaseService.a(this.a.this$0).set(false);
  }
  
  public void a(@NotNull vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramVacAdvRsp, "rsp");
    this.a.this$0.a(paramVacAdvRsp);
    VasRewardAdBaseService.a(this.a.this$0).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.VasRewardAdBaseService.getRequestAdRunnable.1.callback.1
 * JD-Core Version:    0.7.0.1
 */