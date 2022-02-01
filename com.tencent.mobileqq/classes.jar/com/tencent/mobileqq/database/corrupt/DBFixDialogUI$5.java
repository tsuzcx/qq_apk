package com.tencent.mobileqq.database.corrupt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.MobileQQ;

class DBFixDialogUI$5
  implements DialogInterface.OnClickListener
{
  DBFixDialogUI$5(DBFixDialogUI paramDBFixDialogUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    DBFixDialogUI.d(this.a).c();
    paramDialogInterface = this.a.a.getApplication().getSharedPreferences(DBFixManager.d, 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.c);
    localStringBuilder.append(DBFixManager.n);
    paramDialogInterface.remove(localStringBuilder.toString()).commit();
    ReportController.b(this.a.a, "CliOper", "", this.a.c, DBFixDialogUI.i, DBFixDialogUI.i, 0, 0, "", "", "", "");
    DBFixDialogUI.d(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.5
 * JD-Core Version:    0.7.0.1
 */