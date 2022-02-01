package com.tencent.mobileqq.kandian.biz.hippy.api;

import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/hippy/api/IHippyWupCallback;", "", "onWUPTaskFail", "", "code", "", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "onWUPTaskSuccess", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "data", "registerWupCallback", "rspName", "", "rspClassName", "requestId", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mtt/hippy/modules/Promise;Ljava/lang/Integer;)V", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IHippyWupCallback
{
  public abstract void onWUPTaskFail(int paramInt, @NotNull Promise paramPromise);
  
  public abstract void onWUPTaskSuccess(@NotNull ToServiceMsg paramToServiceMsg, int paramInt, @Nullable Object paramObject);
  
  public abstract void registerWupCallback(@Nullable String paramString1, @Nullable String paramString2, @Nullable Promise paramPromise, @Nullable Integer paramInteger);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.api.IHippyWupCallback
 * JD-Core Version:    0.7.0.1
 */