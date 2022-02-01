package com.tencent.mobileqq.vas.adv.base.service;

import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/base/service/VasAdvService$reportAd$innerCallback$1", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvCallback;", "onError", "", "errMsg", "", "e", "", "onRsp", "rspBytes", "", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvService$reportAd$innerCallback$1
  implements VasAdvCallback
{
  VasAdvService$reportAd$innerCallback$1(VasAdvBizCallback paramVasAdvBizCallback) {}
  
  public void a(@NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    VasAdvService localVasAdvService = VasAdvService.a;
    VasAdvBizCallback localVasAdvBizCallback = this.a;
    VasAdvServiceCode localVasAdvServiceCode = VasAdvServiceCode.REPORT_CMD_ERROR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report ad onError: ");
    localStringBuilder.append(paramString);
    VasAdvService.a(localVasAdvService, localVasAdvBizCallback, localVasAdvServiceCode, localStringBuilder.toString(), paramThrowable);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "rspBytes");
    try
    {
      paramArrayOfByte = VasAdvService.a(VasAdvService.a, paramArrayOfByte);
      VasAdvService.a(VasAdvService.a, paramArrayOfByte, this.a);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      VasAdvService localVasAdvService = VasAdvService.a;
      VasAdvBizCallback localVasAdvBizCallback = this.a;
      VasAdvServiceCode localVasAdvServiceCode = VasAdvServiceCode.REPORT_RSP_PARSE_ERR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse report rsp exception: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      VasAdvService.a(localVasAdvService, localVasAdvBizCallback, localVasAdvServiceCode, localStringBuilder.toString(), (Throwable)paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.service.VasAdvService.reportAd.innerCallback.1
 * JD-Core Version:    0.7.0.1
 */