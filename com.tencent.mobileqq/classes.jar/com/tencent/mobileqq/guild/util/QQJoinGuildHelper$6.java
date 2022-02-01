package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class QQJoinGuildHelper$6
  implements DialogInterface.OnClickListener
{
  QQJoinGuildHelper$6(IGProSecurityResult paramIGProSecurityResult, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    try
    {
      paramDialogInterface = new JSONObject(this.a.c()).optString("verify_url");
      Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDialogInterface);
      this.b.startActivity(localIntent);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("QQJoinGuildHelper", 1, paramDialogInterface, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQJoinGuildHelper.6
 * JD-Core Version:    0.7.0.1
 */