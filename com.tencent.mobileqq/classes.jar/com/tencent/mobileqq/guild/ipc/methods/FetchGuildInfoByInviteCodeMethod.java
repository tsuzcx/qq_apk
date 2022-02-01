package com.tencent.mobileqq.guild.ipc.methods;

import com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase;
import eipc.EIPCResult;

public class FetchGuildInfoByInviteCodeMethod
  extends AbsIpcMethod
{
  public EIPCResult a(AbsIpcMethod.IpcContext paramIpcContext, String paramString, Object... paramVarArgs)
  {
    FetchGuildInfoUseCase.a((String)paramVarArgs[0], new FetchGuildInfoByInviteCodeMethod.1(this, paramIpcContext));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.methods.FetchGuildInfoByInviteCodeMethod
 * JD-Core Version:    0.7.0.1
 */