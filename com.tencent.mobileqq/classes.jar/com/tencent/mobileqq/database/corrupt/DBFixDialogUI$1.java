package com.tencent.mobileqq.database.corrupt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class DBFixDialogUI$1
  implements DialogInterface.OnCancelListener
{
  DBFixDialogUI$1(DBFixDialogUI paramDBFixDialogUI) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (DBFixDialogUI.a(this.a).equals("checked corrupt"))
    {
      Object localObject1 = this.a.a.getApplication().getSharedPreferences(DBFixManager.d, 0);
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append(this.a.c);
      paramDialogInterface.append(DBFixManager.s);
      paramDialogInterface = ((SharedPreferences)localObject1).getString(paramDialogInterface.toString(), "");
      localObject1 = ((SharedPreferences)localObject1).edit();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.c);
      ((StringBuilder)localObject2).append(DBFixManager.s);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDialogInterface);
      localStringBuilder.append("_Cancel");
      ((SharedPreferences.Editor)localObject1).putString((String)localObject2, localStringBuilder.toString()).commit();
      QLog.d(DBFixDialogUI.b(), 1, "dialog cancel");
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.1
 * JD-Core Version:    0.7.0.1
 */