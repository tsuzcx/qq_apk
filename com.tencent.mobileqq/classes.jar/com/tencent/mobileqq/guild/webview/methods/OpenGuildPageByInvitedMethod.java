package com.tencent.mobileqq.guild.webview.methods;

import com.tencent.mobileqq.guild.ipc.methods.NavigateToGuildPageWithInvitedInfoMethod;
import com.tencent.mobileqq.guild.util.GuildIpcUtils;
import eipc.EIPCResult;

public class OpenGuildPageByInvitedMethod
  extends AbsJsBridgeMethod
{
  protected boolean a(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = GuildIpcUtils.a(NavigateToGuildPageWithInvitedInfoMethod.class, new Object[] { c("inviteCode"), Integer.valueOf(b("from")) });
    if (paramString2.isSuccess())
    {
      paramString1 = "OK";
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("跳转异常 ");
      paramString1.append(paramString2.code);
      paramString1 = paramString1.toString();
    }
    a(OpenGuildPageByInvitedMethod.InvokeResult.a(paramString2.code, paramString1).a());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.OpenGuildPageByInvitedMethod
 * JD-Core Version:    0.7.0.1
 */