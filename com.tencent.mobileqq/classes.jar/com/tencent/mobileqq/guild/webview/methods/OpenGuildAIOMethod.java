package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import com.tencent.mobileqq.guild.ipc.methods.OpenGuildAIOIpcMethod;
import com.tencent.mobileqq.guild.util.GuildIpcUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class OpenGuildAIOMethod
  extends AbsJsBridgeMethod
{
  private EIPCResultCallback a()
  {
    return new -..Lambda.OpenGuildAIOMethod.OCf7OGjJCEZs_2bZpZyM_TxQi38(this);
  }
  
  private String a(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data == null) {
      return "";
    }
    return paramEIPCResult.data.getString("msg", "");
  }
  
  protected boolean a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a("key", c("guildId"));
    paramString2 = c("packageId");
    GuildIpcUtils.a(OpenGuildAIOIpcMethod.class, a(), new Object[] { paramString1, paramString2 });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.OpenGuildAIOMethod
 * JD-Core Version:    0.7.0.1
 */