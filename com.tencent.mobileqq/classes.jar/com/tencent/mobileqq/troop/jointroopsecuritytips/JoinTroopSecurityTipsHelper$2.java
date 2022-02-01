package com.tencent.mobileqq.troop.jointroopsecuritytips;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;

final class JoinTroopSecurityTipsHelper$2
  implements DialogInterface.OnClickListener
{
  JoinTroopSecurityTipsHelper$2(Context paramContext, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.setClass(this.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.b);
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsHelper.2
 * JD-Core Version:    0.7.0.1
 */