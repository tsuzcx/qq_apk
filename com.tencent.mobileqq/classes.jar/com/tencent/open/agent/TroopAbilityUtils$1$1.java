package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

class TroopAbilityUtils$1$1
  implements DialogInterface.OnClickListener
{
  TroopAbilityUtils$1$1(TroopAbilityUtils.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.a.isFinishing()) {
      paramDialogInterface.dismiss();
    }
    if (paramInt != 0) {
      return;
    }
    try
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.addFlags(335544320);
      if (this.a.b) {
        paramDialogInterface.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.a.c), this.a.d })));
      } else {
        paramDialogInterface.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error", new Object[] { Long.valueOf(this.a.c), this.a.d })));
      }
      paramDialogInterface.setPackage(this.a.e);
      this.a.a.startActivity(paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("TroopAbility.Utils", 1, "[startSdkCallback] startActivity failed, exception=", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityUtils.1.1
 * JD-Core Version:    0.7.0.1
 */