package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class TroopBarPublishUtils$6
  implements DialogInterface.OnClickListener
{
  TroopBarPublishUtils$6(Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      TroopBarPublishUtils.c(this.a);
      paramDialogInterface.dismiss();
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.6
 * JD-Core Version:    0.7.0.1
 */