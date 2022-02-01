package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.error.GuildError;
import com.tencent.mobileqq.guild.ipc.QQGuildSvrIPCModule;
import com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase.GuildInfo;
import com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase.ResultCallback;

class FetchGuildInfoByInviteCodeMethod$1
  implements FetchGuildInfoUseCase.ResultCallback
{
  FetchGuildInfoByInviteCodeMethod$1(FetchGuildInfoByInviteCodeMethod paramFetchGuildInfoByInviteCodeMethod, AbsIpcMethod.IpcContext paramIpcContext) {}
  
  public void a(@NonNull GuildError paramGuildError, @NonNull FetchGuildInfoUseCase.GuildInfo paramGuildInfo)
  {
    paramGuildError = QQGuildSvrIPCModule.a(paramGuildError.a, paramGuildError.b, paramGuildError.c);
    paramGuildError.putParcelable("data", paramGuildInfo);
    this.a.a(paramGuildError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.methods.FetchGuildInfoByInviteCodeMethod.1
 * JD-Core Version:    0.7.0.1
 */