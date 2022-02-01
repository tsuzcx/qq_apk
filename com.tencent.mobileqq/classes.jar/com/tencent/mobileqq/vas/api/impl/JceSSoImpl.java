package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJceSSo;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/JceSSoImpl;", "Lcom/tencent/mobileqq/vas/api/IJceSSo;", "()V", "bindObserverData", "Leipc/EIPCResult;", "type", "", "isSuccess", "", "data", "Ljava/lang/Object;", "request", "", "funcName", "", "jceReq", "Lcom/qq/taf/jce/JceStruct;", "jceResp", "callback", "Leipc/EIPCCallback;", "bgCallback", "jce", "Lcom/tencent/mobileqq/vas/api/IJce;", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class JceSSoImpl
  implements IJceSSo
{
  @NotNull
  public final EIPCResult a(int paramInt, boolean paramBoolean, @Nullable Object paramObject)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = new Bundle();
    localEIPCResult.data.putBoolean("isSuccess", paramBoolean);
    if ((paramObject != null) && ((paramObject instanceof JceStruct))) {
      localEIPCResult.data.putSerializable("rspBytes", (Serializable)paramObject);
    }
    localEIPCResult.data.putInt("type", paramInt);
    return localEIPCResult;
  }
  
  public void a(@NotNull String paramString, @NotNull JceStruct paramJceStruct1, @NotNull JceStruct paramJceStruct2, @NotNull EIPCCallback paramEIPCCallback, boolean paramBoolean, @NotNull IJce paramIJce)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "funcName");
    Intrinsics.checkParameterIsNotNull(paramJceStruct1, "jceReq");
    Intrinsics.checkParameterIsNotNull(paramJceStruct2, "jceResp");
    Intrinsics.checkParameterIsNotNull(paramEIPCCallback, "callback");
    Intrinsics.checkParameterIsNotNull(paramIJce, "jce");
    paramIJce.request(paramString, paramJceStruct1, paramJceStruct2, (BusinessObserver)new JceSSoImpl.request.observer.1(this, paramEIPCCallback), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.JceSSoImpl
 * JD-Core Version:    0.7.0.1
 */