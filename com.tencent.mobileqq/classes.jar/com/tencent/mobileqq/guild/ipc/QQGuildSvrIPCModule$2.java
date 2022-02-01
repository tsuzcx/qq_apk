package com.tencent.mobileqq.guild.ipc;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.error.GuildError;
import com.tencent.mobileqq.guild.usecases.JoinGuildUseCase.ResultCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class QQGuildSvrIPCModule$2
  implements JoinGuildUseCase.ResultCallback
{
  QQGuildSvrIPCModule$2(QQGuildSvrIPCModule paramQQGuildSvrIPCModule, int paramInt) {}
  
  public void a(@NonNull GuildError paramGuildError, String paramString)
  {
    QLog.d("QQGuildSvrIPCModule", 1, new Object[] { "joinBySignature, result=", paramGuildError });
    paramGuildError = QQGuildSvrIPCModule.a(paramGuildError.a, paramGuildError.b, paramGuildError.c);
    paramGuildError.putString("key", paramString);
    this.b.callbackResult(this.a, EIPCResult.createSuccessResult(paramGuildError));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.QQGuildSvrIPCModule.2
 * JD-Core Version:    0.7.0.1
 */