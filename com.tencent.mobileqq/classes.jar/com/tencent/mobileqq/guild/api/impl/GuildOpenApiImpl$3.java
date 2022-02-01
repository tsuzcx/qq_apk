package com.tencent.mobileqq.guild.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class GuildOpenApiImpl$3
  implements DialogInterface.OnClickListener
{
  GuildOpenApiImpl$3(GuildOpenApiImpl paramGuildOpenApiImpl, QQGuildOpenData paramQQGuildOpenData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("errCode", 0);
      paramDialogInterface.put("action", this.a.from);
      paramDialogInterface = paramDialogInterface.toString();
      this.b.handleGuildOpenResult(this.a.packageId, paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("QQGuildOpenApiImpl", 1, paramDialogInterface, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildOpenApiImpl.3
 * JD-Core Version:    0.7.0.1
 */