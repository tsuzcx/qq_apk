package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.ipc.IpcArguments;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public abstract class AbsIpcMethod
{
  public final Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("msg", paramString);
    return localBundle;
  }
  
  public abstract EIPCResult a(AbsIpcMethod.IpcContext paramIpcContext, String paramString, Object... paramVarArgs);
  
  public final EIPCResult a(QIPCModule paramQIPCModule, String paramString, @NonNull Bundle paramBundle, int paramInt)
  {
    paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    paramQIPCModule = new AbsIpcMethod.IpcContext(paramQIPCModule, paramInt, paramBundle);
    paramBundle = paramBundle.getParcelable("args");
    if ((paramBundle instanceof IpcArguments)) {
      return a(paramQIPCModule, paramString, ((IpcArguments)paramBundle).a());
    }
    return a(paramQIPCModule, paramString, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
 * JD-Core Version:    0.7.0.1
 */