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
      paramDialogInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0);
      String str = paramDialogInterface.getString(this.a.jdField_a_of_type_JavaLangString + DBFixManager.k, "");
      paramDialogInterface.edit().putString(this.a.jdField_a_of_type_JavaLangString + DBFixManager.k, str + "_Cancel").commit();
      QLog.d(DBFixDialogUI.a(), 1, "dialog cancel");
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.1
 * JD-Core Version:    0.7.0.1
 */