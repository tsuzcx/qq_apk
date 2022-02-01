package com.tencent.mobileqq.vas.adv.api.impl;

import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.AdvPush.AdvPushRsp;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/api/impl/VasAdvApiImpl$requestPublicAccountAd$1$1", "Lcom/tencent/mobileqq/vas/adv/base/VasAdvBizCallback;", "Lcom/tencent/mobileqq/vas/adv/common/pb/AdvPush$AdvPushRsp;", "onError", "", "code", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errMsg", "", "e", "", "onSucceed", "rsp", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvApiImpl$requestPublicAccountAd$1$1
  implements VasAdvBizCallback<AdvPush.AdvPushRsp>
{
  public void a(@NotNull VasAdvServiceCode paramVasAdvServiceCode, @NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramVasAdvServiceCode, "code");
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    VasAdvApiImpl.access$setNextRequestAdTime$p(this.a.this$0, this.a.a + 600000L);
    paramVasAdvServiceCode = new StringBuilder();
    paramVasAdvServiceCode.append("error when request public account ad:");
    paramVasAdvServiceCode.append(paramString);
    QLog.e("VasAdvApiImpl", 1, paramVasAdvServiceCode.toString(), paramThrowable);
  }
  
  public void a(@NotNull AdvPush.AdvPushRsp paramAdvPushRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramAdvPushRsp, "rsp");
    long l2 = paramAdvPushRsp.next_req_gap.get();
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 600000L;
    }
    VasAdvApiImpl.access$setNextRequestAdTime$p(this.a.this$0, this.a.a + l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.api.impl.VasAdvApiImpl.requestPublicAccountAd.1.1
 * JD-Core Version:    0.7.0.1
 */