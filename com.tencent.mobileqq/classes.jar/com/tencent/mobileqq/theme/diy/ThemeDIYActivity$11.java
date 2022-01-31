package com.tencent.mobileqq.theme.diy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class ThemeDIYActivity$11
  implements DialogInterface.OnClickListener
{
  ThemeDIYActivity$11(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "theme_mall", "diy_out_tips", 0, 1, "1", "", "", "");
    this.this$0.saveOperate(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.11
 * JD-Core Version:    0.7.0.1
 */