package com.tencent.mobileqq.pushdialog;

import azdf;
import azdg;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class PushDialogDbUtil$1
  implements Runnable
{
  public PushDialogDbUtil$1(azdf paramazdf, EntityManager paramEntityManager, String[] paramArrayOfString, long paramLong1, long paramLong2, azdg paramazdg) {}
  
  public void run()
  {
    synchronized (azdf.a(this.this$0))
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PushDialogTemplate.class, true, "mUin=? AND time>=?", this.jdField_a_of_type_ArrayOfJavaLangString, null, null, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("PushDialogDbUtil", 3, "PushDialogTemplate query: " + this.jdField_a_of_type_Long + ", queryTime: " + new Date(this.b));
      }
      if (this.jdField_a_of_type_Azdg != null) {
        this.jdField_a_of_type_Azdg.a(localList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1
 * JD-Core Version:    0.7.0.1
 */