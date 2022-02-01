package com.tencent.mobileqq.theme.diy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bcef;
import com.tencent.mobileqq.app.QQAppInterface;

class ThemeDIYActivity$8
  implements DialogInterface.OnClickListener
{
  ThemeDIYActivity$8(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcef.b(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "theme_mall", "diy_out_tips", 0, 1, "1", "", "", "");
    this.this$0.saveOperate(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.8
 * JD-Core Version:    0.7.0.1
 */