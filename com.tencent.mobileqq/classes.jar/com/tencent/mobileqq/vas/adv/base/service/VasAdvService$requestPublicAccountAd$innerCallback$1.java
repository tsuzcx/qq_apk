package com.tencent.mobileqq.vas.adv.base.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.AdvPush.AdvPushRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/base/service/VasAdvService$requestPublicAccountAd$innerCallback$1", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvCallback;", "onError", "", "errMsg", "", "e", "", "onRsp", "rspBytes", "", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvService$requestPublicAccountAd$innerCallback$1
  implements VasAdvCallback
{
  VasAdvService$requestPublicAccountAd$innerCallback$1(VasAdvBizCallback paramVasAdvBizCallback) {}
  
  public void a(@NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    VasAdvBizCallback localVasAdvBizCallback = this.a;
    VasAdvServiceCode localVasAdvServiceCode = VasAdvServiceCode.REQUEST_CMD_ERROR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("request pa ad error:");
    localStringBuilder.append(paramString);
    localVasAdvBizCallback.a(localVasAdvServiceCode, localStringBuilder.toString(), paramThrowable);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "rspBytes");
    try
    {
      localObject = new AdvPush.AdvPushRsp();
      ((AdvPush.AdvPushRsp)localObject).mergeFrom(paramArrayOfByte);
      this.a.a((MessageMicro)localObject);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = this.a;
      VasAdvServiceCode localVasAdvServiceCode = VasAdvServiceCode.REQUEST_RSP_PARSE_ERR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail to parse rsp:");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      ((VasAdvBizCallback)localObject).a(localVasAdvServiceCode, localStringBuilder.toString(), (Throwable)paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.service.VasAdvService.requestPublicAccountAd.innerCallback.1
 * JD-Core Version:    0.7.0.1
 */