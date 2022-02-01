package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/IPbProtocol;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "request", "", "cmd", "", "req", "Lcom/tencent/mobileqq/pb/MessageMicro;", "rspClass", "Ljava/lang/Class;", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "reqBytes", "", "reqStr", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IPbProtocol
  extends QRouteApi
{
  public abstract void request(@Nullable String paramString, @Nullable MessageMicro<?> paramMessageMicro, @Nullable Class<?> paramClass, @Nullable BusinessObserver paramBusinessObserver);
  
  public abstract void request(@Nullable String paramString1, @Nullable String paramString2, @Nullable BusinessObserver paramBusinessObserver);
  
  public abstract void request(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, @Nullable BusinessObserver paramBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IPbProtocol
 * JD-Core Version:    0.7.0.1
 */