package com.tencent.mobileqq.pushdialog;

import android.database.sqlite.SQLiteException;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Date;

class PushDialogDbUtil$3
  implements Runnable
{
  PushDialogDbUtil$3(PushDialogDbUtil paramPushDialogDbUtil, EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void run()
  {
    try
    {
      synchronized (PushDialogDbUtil.a(this.this$0))
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate);
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PushDialogDbUtil", 0, localSQLiteException.getMessage());
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("PushDialogTemplate insert: ");
        ((StringBuilder)???).append(new Date(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.time));
        ((StringBuilder)???).append(",");
        ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.mUin);
        ((StringBuilder)???).append(",");
        ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.c2c_type);
        QLog.d("PushDialogDbUtil", 3, ((StringBuilder)???).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3
 * JD-Core Version:    0.7.0.1
 */