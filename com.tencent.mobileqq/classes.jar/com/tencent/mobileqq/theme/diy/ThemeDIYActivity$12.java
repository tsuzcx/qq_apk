package com.tencent.mobileqq.theme.diy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ThemeDIYActivity$12
  implements DialogInterface.OnClickListener
{
  ThemeDIYActivity$12(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "theme_mall", "diy_out_tips", 0, 1, "0", "", "", "");
    this.this$0.isNotifyBack = false;
    if ((this.this$0.exitDialog != null) && (this.this$0.exitDialog.isShowing()))
    {
      this.this$0.exitDialog.dismiss();
      this.this$0.exitDialog = null;
    }
    this.this$0.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.12
 * JD-Core Version:    0.7.0.1
 */