package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredTipsBar;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.statistics.ReportController;

final class VipUtils$1
  implements DialogInterface.OnClickListener
{
  VipUtils$1(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a)
    {
      paramDialogInterface = new Intent(this.b, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", String.format(BigTroopExpiredTipsBar.a, new Object[] { this.c, "group_aio_popup" }));
      paramDialogInterface.putExtra("hide_operation_bar", true);
      this.b.startActivity(paramDialogInterface);
    }
    else
    {
      TroopManager.LiangGroupHelper.a(this.b, this.c, "group_aio_popup");
    }
    ReportController.b(null, "dc00898", "", "", "qq_vip", this.d, this.e, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.1
 * JD-Core Version:    0.7.0.1
 */