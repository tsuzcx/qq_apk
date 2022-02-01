package com.tencent.mobileqq.pushdialog;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Date;
import java.util.List;

class PushDialogDbUtil$1
  implements Runnable
{
  PushDialogDbUtil$1(PushDialogDbUtil paramPushDialogDbUtil, EntityManager paramEntityManager, String[] paramArrayOfString, long paramLong1, long paramLong2, PushDialogDbUtil.OnPushDialogDbAction paramOnPushDialogDbAction) {}
  
  public void run()
  {
    synchronized (PushDialogDbUtil.a(this.this$0))
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PushDialogTemplate.class, true, "mUin=? AND time>=?", this.jdField_a_of_type_ArrayOfJavaLangString, null, null, null, null);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("PushDialogTemplate query: ");
        ((StringBuilder)???).append(this.jdField_a_of_type_Long);
        ((StringBuilder)???).append(", queryTime: ");
        ((StringBuilder)???).append(new Date(this.b));
        QLog.d("PushDialogDbUtil", 3, ((StringBuilder)???).toString());
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogDbUtil$OnPushDialogDbAction;
      if (??? != null) {
        ((PushDialogDbUtil.OnPushDialogDbAction)???).a(localList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1
 * JD-Core Version:    0.7.0.1
 */