package com.tencent.mobileqq.pushdialog;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;

public class PushDialogDbUtil
{
  private static volatile PushDialogDbUtil jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogDbUtil;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static PushDialogDbUtil a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogDbUtil == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogDbUtil == null) {
          jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogDbUtil = new PushDialogDbUtil();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogDbUtil;
  }
  
  public void a(EntityManager paramEntityManager, long paramLong, PushDialogDbUtil.OnPushDialogDbAction paramOnPushDialogDbAction)
  {
    long l = System.currentTimeMillis() - 86400000L;
    ThreadManager.post(new PushDialogDbUtil.1(this, paramEntityManager, new String[] { String.valueOf(paramLong), String.valueOf(l) }, paramLong, l, paramOnPushDialogDbAction), 8, null, false);
  }
  
  public void a(EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate)
  {
    ThreadManager.post(new PushDialogDbUtil.2(this, paramEntityManager, paramPushDialogTemplate), 8, null, false);
  }
  
  public void b(EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate)
  {
    if (paramEntityManager != null)
    {
      if (paramPushDialogTemplate == null) {
        return;
      }
      ThreadManager.post(new PushDialogDbUtil.3(this, paramEntityManager, paramPushDialogTemplate), 2, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil
 * JD-Core Version:    0.7.0.1
 */