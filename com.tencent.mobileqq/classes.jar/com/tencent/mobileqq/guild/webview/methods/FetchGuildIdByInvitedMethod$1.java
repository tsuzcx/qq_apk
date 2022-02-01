package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase.GuildInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class FetchGuildIdByInvitedMethod$1
  implements EIPCResultCallback
{
  FetchGuildIdByInvitedMethod$1(FetchGuildIdByInvitedMethod paramFetchGuildIdByInvitedMethod) {}
  
  public void onCallback(@NonNull EIPCResult paramEIPCResult)
  {
    if (!paramEIPCResult.isSuccess())
    {
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IPC错误: ");
      localStringBuilder.append(paramEIPCResult.code);
      ((FetchGuildIdByInvitedMethod)localObject).a(FetchGuildIdByInvitedMethod.InvokeResult.a(-201, localStringBuilder.toString(), "").a());
      return;
    }
    int i = paramEIPCResult.data.getInt("errCode");
    Object localObject = paramEIPCResult.data.getString("errMsg");
    paramEIPCResult = (FetchGuildInfoUseCase.GuildInfo)paramEIPCResult.data.getParcelable("data");
    if ((!a) && (paramEIPCResult == null)) {
      throw new AssertionError();
    }
    this.b.a(FetchGuildIdByInvitedMethod.InvokeResult.a(i, (String)localObject, paramEIPCResult.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.FetchGuildIdByInvitedMethod.1
 * JD-Core Version:    0.7.0.1
 */