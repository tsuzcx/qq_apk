package com.tencent.mobileqq.pushdialog;

import android.database.sqlite.SQLiteException;
import awgf;
import awza;
import com.tencent.TMG.utils.QLog;
import java.util.Date;

public class PushDialogDbUtil$3
  implements Runnable
{
  public PushDialogDbUtil$3(awza paramawza, awgf paramawgf, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void run()
  {
    synchronized (awza.a(this.this$0))
    {
      try
      {
        this.jdField_a_of_type_Awgf.a(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate);
        if (QLog.isColorLevel()) {
          QLog.d("PushDialogDbUtil", 3, "PushDialogTemplate insert: " + new Date(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.time) + "," + this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.mUin + "," + this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.c2c_type);
        }
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PushDialogDbUtil", 0, localSQLiteException.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3
 * JD-Core Version:    0.7.0.1
 */