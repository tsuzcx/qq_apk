package com.tencent.mobileqq.guild.open;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class GuildOpenVerifyFragment$2
  implements DialogInterface.OnClickListener
{
  GuildOpenVerifyFragment$2(GuildOpenVerifyFragment paramGuildOpenVerifyFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.d == paramDialogInterface)
    {
      if (paramInt == 1)
      {
        if (GuildOpenVerifyFragment.b(this.a))
        {
          paramDialogInterface = new Intent();
          paramDialogInterface.putExtra("key_params", GuildOpenVerifyFragment.c(this.a));
          paramDialogInterface.putExtra("is_change_account", true);
          paramDialogInterface.putExtra("fromGuildOpen", true);
          paramDialogInterface.addFlags(268435456);
          paramDialogInterface.addFlags(67108864);
          RouteUtils.a(this.a.getQBaseActivity(), paramDialogInterface, "/base/login");
          this.a.getQBaseActivity().finish();
          return;
        }
        GuildOpenVerifyFragment.d(this.a);
        return;
      }
      if (paramInt == 0) {
        try
        {
          paramDialogInterface = new JSONObject();
          paramDialogInterface.put("errCode", -1);
          paramDialogInterface.put("errMsg", "user cancel");
          boolean bool = "create".equals(GuildOpenVerifyFragment.c(this.a).getString("extra_action"));
          if (bool) {
            paramDialogInterface.put("action", "guildOpenCreate");
          } else if ("join".equals(GuildOpenVerifyFragment.c(this.a).getString("extra_action"))) {
            paramDialogInterface.put("action", "guildOpenJoin");
          }
          paramDialogInterface = paramDialogInterface.toString();
          ((IGuildOpenApi)this.a.a.getRuntimeService(IGuildOpenApi.class, "")).handleGuildOpenResult(GuildOpenVerifyFragment.a(this.a).packageId, paramDialogInterface, GuildOpenVerifyFragment.a(this.a).appId, GuildOpenVerifyFragment.a(this.a).openId);
          this.a.getQBaseActivity().finish();
          return;
        }
        catch (Exception paramDialogInterface)
        {
          QLog.e("QQGuildOpenVerifyFragment", 1, paramDialogInterface, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.open.GuildOpenVerifyFragment.2
 * JD-Core Version:    0.7.0.1
 */