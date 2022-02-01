package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

public class AddGuildMethod
  extends AbsJsBridgeMethod
{
  protected boolean a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("inviteCode", c("inviteCode"));
    paramString1.putInt("from", a("from", 246610));
    QIPCClientHelper.getInstance().callServer("module_ipc_server_guild", "addGuild", paramString1, new AddGuildMethod.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.AddGuildMethod
 * JD-Core Version:    0.7.0.1
 */