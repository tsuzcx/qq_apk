package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ExpandFlutterIPCServer$23
  implements IpcDispatchCenter.IpcSyncHandler
{
  ExpandFlutterIPCServer$23(ExpandFlutterIPCServer paramExpandFlutterIPCServer) {}
  
  @NotNull
  public Bundle a(@NotNull String paramString, @Nullable Bundle paramBundle, int paramInt)
  {
    if (AppNetConnInfo.isWifiConn()) {
      paramInt = 1;
    } else if (AppNetConnInfo.isMobileConn()) {
      paramInt = 2;
    } else {
      paramInt = 0;
    }
    paramString = new Bundle();
    paramString.putInt("data", paramInt);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.23
 * JD-Core Version:    0.7.0.1
 */