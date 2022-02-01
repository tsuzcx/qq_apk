package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.util.QQGuildTabStateUtils;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import eipc.EIPCResult;

public class NavigateToGuildPageWithInvitedInfoMethod
  extends AbsIpcMethod
{
  public EIPCResult a(AbsIpcMethod.IpcContext paramIpcContext, String paramString, Object... paramVarArgs)
  {
    paramString = QBaseActivity.sTopActivity;
    paramIpcContext = paramString;
    if (paramString == null) {
      paramIpcContext = QQGuildUtil.h();
    }
    paramString = (String)paramVarArgs[0];
    int i = ((Integer)paramVarArgs[1]).intValue();
    if (!QQGuildTabStateUtils.a()) {
      return EIPCResult.createResult(-204, new Bundle());
    }
    QQGuildUtil.a(paramIpcContext, paramString, i);
    return EIPCResult.createSuccessResult(new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.methods.NavigateToGuildPageWithInvitedInfoMethod
 * JD-Core Version:    0.7.0.1
 */