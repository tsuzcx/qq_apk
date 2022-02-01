package com.tencent.mobileqq.qqexpand.ipc;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/ipc/IExpandFlutterIPCServerHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getIPCServer", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getProcessName", "", "notifyPushEvent", "", "pushType", "", "buffer", "", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandFlutterIPCServerHelper
  extends QRouteApi
{
  @NotNull
  public abstract QIPCModule getIPCServer();
  
  @NotNull
  public abstract String getProcessName();
  
  public abstract void notifyPushEvent(long paramLong, @NotNull byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper
 * JD-Core Version:    0.7.0.1
 */