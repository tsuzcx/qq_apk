package com.tencent.mobileqq.guild.webview.methods;

import com.tencent.mobileqq.guild.ipc.methods.FetchGuildInfoByInviteCodeMethod;
import com.tencent.mobileqq.guild.util.GuildIpcUtils;
import eipc.EIPCResultCallback;

public class FetchGuildIdByInvitedMethod
  extends AbsJsBridgeMethod
{
  private EIPCResultCallback a()
  {
    return new FetchGuildIdByInvitedMethod.1(this);
  }
  
  protected boolean a(String paramString1, String paramString2, String paramString3)
  {
    GuildIpcUtils.a(FetchGuildInfoByInviteCodeMethod.class, a(), new Object[] { c("inviteCode") });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.FetchGuildIdByInvitedMethod
 * JD-Core Version:    0.7.0.1
 */