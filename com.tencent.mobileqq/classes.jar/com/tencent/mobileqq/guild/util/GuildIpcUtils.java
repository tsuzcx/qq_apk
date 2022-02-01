package com.tencent.mobileqq.guild.util;

import android.os.Bundle;
import com.tencent.mobileqq.guild.ipc.IpcArguments;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class GuildIpcUtils
{
  public static EIPCResult a(Class<? extends AbsIpcMethod> paramClass, Object... paramVarArgs)
  {
    return a(paramClass.getCanonicalName(), paramVarArgs);
  }
  
  public static EIPCResult a(String paramString, Object... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("args", new IpcArguments(paramVarArgs));
    return QIPCClientHelper.getInstance().callServer("module_ipc_server_guild", paramString, localBundle);
  }
  
  public static void a(Class<? extends AbsIpcMethod> paramClass, EIPCResultCallback paramEIPCResultCallback, Object... paramVarArgs)
  {
    a(paramClass.getCanonicalName(), paramEIPCResultCallback, paramVarArgs);
  }
  
  public static void a(String paramString, EIPCResultCallback paramEIPCResultCallback, Object... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("args", new IpcArguments(paramVarArgs));
    QIPCClientHelper.getInstance().callServer("module_ipc_server_guild", paramString, localBundle, paramEIPCResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildIpcUtils
 * JD-Core Version:    0.7.0.1
 */