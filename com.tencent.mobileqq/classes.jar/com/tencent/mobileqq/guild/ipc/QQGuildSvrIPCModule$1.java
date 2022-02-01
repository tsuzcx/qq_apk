package com.tencent.mobileqq.guild.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class QQGuildSvrIPCModule$1
  implements IResultWithSecurityCallback
{
  QQGuildSvrIPCModule$1(QQGuildSvrIPCModule paramQQGuildSvrIPCModule, String paramString, int paramInt) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    QLog.d("QQGuildSvrIPCModule", 1, new Object[] { "onAddGuildResult, result=", Integer.valueOf(paramInt), ", errMsg=", paramString, ",security:", paramIGProSecurityResult });
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult))) {
      try
      {
        paramIGProSecurityResult = new Bundle();
        paramIGProSecurityResult.putString("key", this.a);
        paramIGProSecurityResult.putInt("errCode", paramInt);
        paramIGProSecurityResult.putString("errMsg", paramString);
        this.c.callbackResult(this.b, EIPCResult.createSuccessResult(paramIGProSecurityResult));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("QQGuildSvrIPCModule", 1, paramString.getMessage());
        QQGuildSvrIPCModule.a(this.c, this.b, -1, paramString.getMessage());
        return;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key", this.a);
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    if (paramIGProSecurityResult != null)
    {
      localBundle.putLong("actionCode", paramIGProSecurityResult.a());
      localBundle.putString("strPrompt", paramIGProSecurityResult.b());
      localBundle.putString("strDetail", paramIGProSecurityResult.c());
    }
    this.c.callbackResult(this.b, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.QQGuildSvrIPCModule.1
 * JD-Core Version:    0.7.0.1
 */