package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.statistics.ReportController;

final class TroopBarPublishUtils$5
  implements DialogInterface.OnClickListener
{
  TroopBarPublishUtils$5(Bundle paramBundle, int paramInt1, int paramInt2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopBarPublishUtils.a().a();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("bid", "0");
      String str1;
      if ("interestcircle".endsWith(this.jdField_a_of_type_AndroidOsBundle.getString("from")))
      {
        paramDialogInterface = "pub_page_new";
        if (this.jdField_a_of_type_Int != 3) {
          break label144;
        }
        str1 = "Clk_cancel";
        label79:
        if (this.jdField_a_of_type_Int != 3) {
          break label155;
        }
        if (!"0".endsWith(str2)) {
          break label150;
        }
        paramInt = 2;
      }
      for (;;)
      {
        ReportController.b(null, "dc00899", "Grp_tribe", "", paramDialogInterface, str1, paramInt, 0, str2, "", "", "");
        return;
        if ("0".endsWith(str2)) {}
        for (paramDialogInterface = "pub_page_new";; paramDialogInterface = "reply_page_new") {
          break;
        }
        label144:
        str1 = "Clk_cancelup";
        break label79;
        label150:
        paramInt = 1;
        continue;
        label155:
        paramInt = 0;
      }
    }
    paramDialogInterface.dismiss();
    TroopBarPublishUtils.a(this.b, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.5
 * JD-Core Version:    0.7.0.1
 */