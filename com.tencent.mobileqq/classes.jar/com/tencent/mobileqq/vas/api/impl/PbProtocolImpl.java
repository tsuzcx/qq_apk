package com.tencent.mobileqq.vas.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.util.VasUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/PbProtocolImpl;", "Lcom/tencent/mobileqq/vas/api/IPbProtocol;", "()V", "getExtensionHandler", "Lcom/tencent/mobileqq/apollo/handler/IApolloExtensionHandler;", "request", "", "cmd", "", "req", "Lcom/tencent/mobileqq/pb/MessageMicro;", "rspClass", "Ljava/lang/Class;", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "reqBytes", "", "reqStr", "Companion", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class PbProtocolImpl
  implements IPbProtocol
{
  public static final PbProtocolImpl.Companion Companion = new PbProtocolImpl.Companion(null);
  private static final String TAG = "PbProtocol";
  private static long seq;
  
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
    return Companion.a(paramArrayOfByte);
  }
  
  @Nullable
  public final IApolloExtensionHandler getExtensionHandler()
  {
    BusinessHandler localBusinessHandler = VasUtil.a().getBusinessHandler(ApolloClassFactoryApi.b());
    if (localBusinessHandler != null) {
      return (IApolloExtensionHandler)localBusinessHandler;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler");
  }
  
  public void request(@Nullable String paramString, @Nullable MessageMicro<?> paramMessageMicro, @Nullable Class<?> paramClass, @Nullable BusinessObserver paramBusinessObserver)
  {
    IApolloExtensionHandler localIApolloExtensionHandler = getExtensionHandler();
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.a(paramString, paramMessageMicro, paramClass, paramBusinessObserver);
    }
  }
  
  public void request(@Nullable String paramString1, @Nullable String paramString2, @Nullable BusinessObserver paramBusinessObserver)
  {
    IApolloExtensionHandler localIApolloExtensionHandler = getExtensionHandler();
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.a(paramString1, paramString2, paramBusinessObserver);
    }
  }
  
  public void request(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, @Nullable BusinessObserver paramBusinessObserver)
  {
    IApolloExtensionHandler localIApolloExtensionHandler = getExtensionHandler();
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.a(paramString, paramArrayOfByte, paramBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.PbProtocolImpl
 * JD-Core Version:    0.7.0.1
 */