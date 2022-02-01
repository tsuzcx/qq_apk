package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import eipc.EIPCCallback.Stub;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/api/impl/PbProtocolImpl$getEipcCallback$callback$1", "Leipc/EIPCCallback$Stub;", "callback", "", "result", "Leipc/EIPCResult;", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class PbProtocolImpl$getEipcCallback$callback$1
  extends EIPCCallback.Stub
{
  PbProtocolImpl$getEipcCallback$callback$1(BusinessObserver paramBusinessObserver) {}
  
  public void callback(@NotNull EIPCResult paramEIPCResult)
  {
    Intrinsics.checkParameterIsNotNull(paramEIPCResult, "result");
    this.a.getDataAndCallback(paramEIPCResult, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.PbProtocolImpl.getEipcCallback.callback.1
 * JD-Core Version:    0.7.0.1
 */