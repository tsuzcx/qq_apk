package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import eipc.EIPCCallback;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/IPbProtocolSSo;", "Ljava/io/Serializable;", "request", "", "cmd", "", "req", "Lcom/tencent/mobileqq/pb/MessageMicro;", "rspClass", "Ljava/lang/Class;", "callback", "Leipc/EIPCCallback;", "reqBytes", "", "reqStr", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IPbProtocolSSo
  extends Serializable
{
  public abstract void request(@Nullable String paramString, @Nullable MessageMicro<?> paramMessageMicro, @Nullable Class<?> paramClass, @Nullable EIPCCallback paramEIPCCallback);
  
  public abstract void request(@Nullable String paramString1, @Nullable String paramString2, @Nullable EIPCCallback paramEIPCCallback);
  
  public abstract void request(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, @Nullable EIPCCallback paramEIPCCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IPbProtocolSSo
 * JD-Core Version:    0.7.0.1
 */