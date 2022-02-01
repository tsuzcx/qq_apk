package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import eipc.EIPCCallback;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class PbProtocolSSoImpl$getBusinessObserver$1
  implements BusinessObserver
{
  PbProtocolSSoImpl$getBusinessObserver$1(PbProtocolSSoImpl paramPbProtocolSSoImpl, EIPCCallback paramEIPCCallback) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    EIPCCallback localEIPCCallback = this.b;
    if (localEIPCCallback != null)
    {
      PbProtocolSSoImpl localPbProtocolSSoImpl = this.a;
      if (paramObject != null)
      {
        localEIPCCallback.callback(localPbProtocolSSoImpl.bindObserverData(paramInt, paramBoolean, paramObject));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl.getBusinessObserver.1
 * JD-Core Version:    0.7.0.1
 */