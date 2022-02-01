package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.api.IPbProtocolSSo;
import com.tencent.mobileqq.vas.util.VasUtil;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/PbProtocolSSoImpl;", "Lcom/tencent/mobileqq/vas/api/IPbProtocolSSo;", "()V", "bindObserverData", "Leipc/EIPCResult;", "type", "", "isSuccess", "", "data", "Ljava/lang/Object;", "getBusinessObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "callback", "Leipc/EIPCCallback;", "getExtensionHandler", "Lcom/tencent/mobileqq/apollo/handler/IApolloExtensionHandler;", "request", "", "cmd", "", "req", "Lcom/tencent/mobileqq/pb/MessageMicro;", "rspClass", "Ljava/lang/Class;", "reqBytes", "", "reqStr", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class PbProtocolSSoImpl
  implements IPbProtocolSSo
{
  @NotNull
  public final EIPCResult bindObserverData(int paramInt, boolean paramBoolean, @Nullable Object paramObject)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = new Bundle();
    localEIPCResult.data.putBoolean("isSuccess", paramBoolean);
    if (paramObject != null) {
      localEIPCResult.data.putByteArray("rspBytes", PbProtocolImpl.Companion.b((byte[])paramObject));
    }
    localEIPCResult.data.putInt("type", paramInt);
    return localEIPCResult;
  }
  
  @NotNull
  public final BusinessObserver getBusinessObserver(@Nullable EIPCCallback paramEIPCCallback)
  {
    return (BusinessObserver)new PbProtocolSSoImpl.getBusinessObserver.1(this, paramEIPCCallback);
  }
  
  @Nullable
  public final IApolloExtensionHandler getExtensionHandler()
  {
    BusinessHandler localBusinessHandler = VasUtil.d().getBusinessHandler(ApolloClassFactoryApi.h());
    if (localBusinessHandler != null) {
      return (IApolloExtensionHandler)localBusinessHandler;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler");
  }
  
  public void request(@Nullable String paramString, @Nullable MessageMicro<?> paramMessageMicro, @Nullable Class<?> paramClass, @Nullable EIPCCallback paramEIPCCallback)
  {
    IApolloExtensionHandler localIApolloExtensionHandler = getExtensionHandler();
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.a(paramString, paramMessageMicro, paramClass, getBusinessObserver(paramEIPCCallback));
    }
  }
  
  public void request(@Nullable String paramString1, @Nullable String paramString2, @Nullable EIPCCallback paramEIPCCallback)
  {
    IApolloExtensionHandler localIApolloExtensionHandler = getExtensionHandler();
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.a(paramString1, paramString2, getBusinessObserver(paramEIPCCallback));
    }
  }
  
  public void request(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, @Nullable EIPCCallback paramEIPCCallback)
  {
    IApolloExtensionHandler localIApolloExtensionHandler = getExtensionHandler();
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.a(paramString, paramArrayOfByte, getBusinessObserver(paramEIPCCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl
 * JD-Core Version:    0.7.0.1
 */