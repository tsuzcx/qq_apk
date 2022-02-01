package com.tencent.mobileqq.qqexpand.ipc.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer;
import com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/ipc/impl/ExpandFlutterIPCServerHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/ipc/IExpandFlutterIPCServerHelper;", "()V", "getIPCServer", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getProcessName", "", "notifyPushEvent", "", "pushType", "", "buffer", "", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterIPCServerHelperImpl
  implements IExpandFlutterIPCServerHelper
{
  @NotNull
  public QIPCModule getIPCServer()
  {
    ExpandFlutterIPCServer localExpandFlutterIPCServer = ExpandFlutterIPCServer.a();
    Intrinsics.checkExpressionValueIsNotNull(localExpandFlutterIPCServer, "ExpandFlutterIPCServer.getInstance()");
    return (QIPCModule)localExpandFlutterIPCServer;
  }
  
  @NotNull
  public String getProcessName()
  {
    String str = ExpandFlutterIPCServer.a();
    Intrinsics.checkExpressionValueIsNotNull(str, "ExpandFlutterIPCServer.getProcessName()");
    return str;
  }
  
  public void notifyPushEvent(long paramLong, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "buffer");
    ExpandFlutterIPCServer.a().a(paramLong, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.impl.ExpandFlutterIPCServerHelperImpl
 * JD-Core Version:    0.7.0.1
 */