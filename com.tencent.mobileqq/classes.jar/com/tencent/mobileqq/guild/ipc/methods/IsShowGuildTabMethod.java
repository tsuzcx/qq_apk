package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.guild.util.QQGuildTabStateUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class IsShowGuildTabMethod
  extends AbsIpcMethod
{
  public EIPCResult a(AbsIpcMethod.IpcContext paramIpcContext, String paramString, Object... paramVarArgs)
  {
    boolean bool = QQGuildTabStateUtils.a();
    paramIpcContext = new Bundle();
    paramIpcContext.putBoolean("ret", bool);
    QLog.d("IsShowGuildTabMethod", 1, new Object[] { "invoke result: isTabShow: ", Boolean.valueOf(bool) });
    return EIPCResult.createSuccessResult(paramIpcContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.methods.IsShowGuildTabMethod
 * JD-Core Version:    0.7.0.1
 */