package com.tencent.mobileqq.troop.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.statistics.ReportController;

final class TroopBarPublishUtils$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopBarPublishUtils.b().a();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramDialogInterface.dismiss();
      TroopBarPublishUtils.a(this.c, this.d, this.a);
      return;
    }
    paramDialogInterface.dismiss();
    String str2 = this.a.getString("bid", "0");
    boolean bool = "interestcircle".endsWith(this.a.getString("from"));
    paramDialogInterface = "pub_page_new";
    if (!bool) {
      for (;;)
      {
        if (!"0".endsWith(str2)) {
          paramDialogInterface = "reply_page_new";
        }
      }
    }
    String str1;
    if (this.b == 3) {
      str1 = "Clk_cancel";
    } else {
      str1 = "Clk_cancelup";
    }
    if (this.b == 3)
    {
      if ("0".endsWith(str2)) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
    }
    else {
      paramInt = 0;
    }
    ReportController.b(null, "dc00899", "Grp_tribe", "", paramDialogInterface, str1, paramInt, 0, str2, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.5
 * JD-Core Version:    0.7.0.1
 */