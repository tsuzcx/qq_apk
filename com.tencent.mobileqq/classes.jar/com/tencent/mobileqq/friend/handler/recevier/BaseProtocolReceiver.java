package com.tencent.mobileqq.friend.handler.recevier;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/handler/recevier/BaseProtocolReceiver;", "T", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "appRuntime", "Lcom/tencent/common/app/AppInterface;", "handler", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/app/BusinessHandler;)V", "getAppRuntime", "()Lcom/tencent/common/app/AppInterface;", "getHandler", "()Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "cmdFilter", "", "cmd", "", "getCmd", "receive", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "IMCore_release"}, k=1, mv={1, 1, 16})
public abstract class BaseProtocolReceiver<T extends BusinessHandler>
{
  @NotNull
  private final AppInterface a;
  @NotNull
  private final T b;
  
  public BaseProtocolReceiver(@NotNull AppInterface paramAppInterface, @NotNull T paramT)
  {
    this.a = paramAppInterface;
    this.b = paramT;
  }
  
  @NotNull
  public abstract String a();
  
  public abstract void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject);
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    return Intrinsics.areEqual(a(), paramString);
  }
  
  @NotNull
  public final AppInterface b()
  {
    return this.a;
  }
  
  @NotNull
  public final T c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.BaseProtocolReceiver
 * JD-Core Version:    0.7.0.1
 */