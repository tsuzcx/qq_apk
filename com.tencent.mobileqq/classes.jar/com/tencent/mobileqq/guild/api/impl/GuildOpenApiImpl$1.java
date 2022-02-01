package com.tencent.mobileqq.guild.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class GuildOpenApiImpl$1
  implements DialogInterface.OnClickListener
{
  GuildOpenApiImpl$1(GuildOpenApiImpl paramGuildOpenApiImpl, String paramString, GuildOpenApiImpl.GuildPackageData paramGuildPackageData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("errCode", 0);
      paramDialogInterface.put("action", this.a);
      paramDialogInterface = paramDialogInterface.toString();
      this.c.handleGuildOpenResult(this.b.a, paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("QQGuildOpenApiImpl", 1, paramDialogInterface, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildOpenApiImpl.1
 * JD-Core Version:    0.7.0.1
 */