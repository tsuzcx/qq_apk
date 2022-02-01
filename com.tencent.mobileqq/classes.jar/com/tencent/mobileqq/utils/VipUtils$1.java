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
    if (!this.jdField_a_of_type_Boolean)
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", String.format(BigTroopExpiredTipsBar.jdField_a_of_type_JavaLangString, new Object[] { this.jdField_a_of_type_JavaLangString, "group_aio_popup" }));
      paramDialogInterface.putExtra("hide_operation_bar", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "qq_vip", this.b, this.jdField_a_of_type_Int, 0, "", "", "", "");
      return;
      TroopManager.LiangGroupHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, "group_aio_popup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.1
 * JD-Core Version:    0.7.0.1
 */