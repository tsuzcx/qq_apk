package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.IPbProtocolSSo;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/PbProtocolImpl;", "Lcom/tencent/mobileqq/vas/api/IPbProtocol;", "()V", "managerName", "", "getManagerName", "()Ljava/lang/String;", "getDataAndCallback", "", "result", "Leipc/EIPCResult;", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "getEipcCallback", "Leipc/EIPCCallback;", "getExtensionHandler", "Lcom/tencent/mobileqq/apollo/handler/IApolloExtensionHandler;", "isMainProcess", "", "request", "cmd", "req", "Lcom/tencent/mobileqq/pb/MessageMicro;", "rspClass", "Ljava/lang/Class;", "reqBytes", "", "reqStr", "Companion", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class PbProtocolImpl
  implements IPbProtocol
{
  public static final PbProtocolImpl.Companion Companion = new PbProtocolImpl.Companion(null);
  private static long a;
  
  private final EIPCCallback a(BusinessObserver paramBusinessObserver)
  {
    return (EIPCCallback)new PbProtocolImpl.getEipcCallback.callback.1(this, paramBusinessObserver);
  }
  
  @JvmStatic
  @Nullable
  public static final String generateDeviceInfo()
  {
    return Companion.a();
  }
  
  @JvmStatic
  @Nullable
  public static final String generateTraceId()
  {
    return Companion.b();
  }
  
  @JvmStatic
  @NotNull
  public static final MessageMicro<?> getRequestWrapper(@Nullable byte[] paramArrayOfByte)
  {
    return Companion.a(paramArrayOfByte);
  }
  
  @JvmStatic
  @NotNull
  public static final Object[] parseResponseWrapper(@Nullable byte[] paramArrayOfByte)
  {
    return Companion.c(paramArrayOfByte);
  }
  
  public final void getDataAndCallback(@NotNull EIPCResult paramEIPCResult, @Nullable BusinessObserver paramBusinessObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramEIPCResult, "result");
    if (paramEIPCResult.data != null)
    {
      byte[] arrayOfByte = paramEIPCResult.data.getByteArray("rspBytes");
      boolean bool = paramEIPCResult.data.getBoolean("isSuccess");
      int i = paramEIPCResult.data.getInt("type");
      if (paramBusinessObserver != null) {
        paramBusinessObserver.onUpdate(i, bool, arrayOfByte);
      }
    }
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
  
  @NotNull
  public String getManagerName()
  {
    String str = getClass().getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "this.javaClass.name");
    return str;
  }
  
  public final boolean isMainProcess()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    return Intrinsics.areEqual(localBaseApplication.getPackageName(), MobileQQ.processName);
  }
  
  public void request(@Nullable String paramString, @Nullable MessageMicro<?> paramMessageMicro, @Nullable Class<?> paramClass, @Nullable BusinessObserver paramBusinessObserver)
  {
    if (!isMainProcess())
    {
      paramBusinessObserver = a(paramBusinessObserver);
      localObject = RemoteProxy.a(PbProtocolSSoImpl.class);
      if (localObject != null)
      {
        ((IPbProtocolSSo)localObject).request(paramString, paramMessageMicro, paramClass, paramBusinessObserver);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vas.api.IPbProtocolSSo");
    }
    Object localObject = getExtensionHandler();
    if (localObject != null) {
      ((IApolloExtensionHandler)localObject).a(paramString, paramMessageMicro, paramClass, paramBusinessObserver);
    }
  }
  
  public void request(@Nullable String paramString1, @Nullable String paramString2, @Nullable BusinessObserver paramBusinessObserver)
  {
    if (!isMainProcess())
    {
      paramBusinessObserver = a(paramBusinessObserver);
      localObject = RemoteProxy.a(PbProtocolSSoImpl.class);
      if (localObject != null)
      {
        ((IPbProtocolSSo)localObject).request(paramString1, paramString2, paramBusinessObserver);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vas.api.IPbProtocolSSo");
    }
    Object localObject = getExtensionHandler();
    if (localObject != null) {
      ((IApolloExtensionHandler)localObject).a(paramString1, paramString2, paramBusinessObserver);
    }
  }
  
  public void request(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, @Nullable BusinessObserver paramBusinessObserver)
  {
    if (!isMainProcess())
    {
      paramBusinessObserver = a(paramBusinessObserver);
      localObject = RemoteProxy.a(PbProtocolSSoImpl.class);
      if (localObject != null)
      {
        ((IPbProtocolSSo)localObject).request(paramString, paramArrayOfByte, paramBusinessObserver);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vas.api.IPbProtocolSSo");
    }
    Object localObject = getExtensionHandler();
    if (localObject != null) {
      ((IApolloExtensionHandler)localObject).a(paramString, paramArrayOfByte, paramBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.PbProtocolImpl
 * JD-Core Version:    0.7.0.1
 */