package com.tencent.mobileqq.database.corrupt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class DBFixDialogUI$3
  implements DialogInterface.OnClickListener
{
  DBFixDialogUI$3(DBFixDialogUI paramDBFixDialogUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    QLog.d(DBFixDialogUI.a(), 1, "showConfirmDialog, cancel click");
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_JavaLangString, DBFixDialogUI.d, DBFixDialogUI.d, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.3
 * JD-Core Version:    0.7.0.1
 */