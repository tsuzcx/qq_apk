package com.tencent.mobileqq.theme.diy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import azmj;
import bdfq;
import com.tencent.mobileqq.app.QQAppInterface;

class ThemeDIYActivity$9
  implements DialogInterface.OnClickListener
{
  ThemeDIYActivity$9(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    azmj.b(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "theme_mall", "diy_out_tips", 0, 1, "0", "", "", "");
    this.this$0.isNotifyBack = false;
    if ((this.this$0.exitDialog != null) && (this.this$0.exitDialog.isShowing()))
    {
      this.this$0.exitDialog.dismiss();
      this.this$0.exitDialog = null;
    }
    this.this$0.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.9
 * JD-Core Version:    0.7.0.1
 */