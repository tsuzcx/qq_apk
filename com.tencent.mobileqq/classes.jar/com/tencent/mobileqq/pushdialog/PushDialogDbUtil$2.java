package com.tencent.mobileqq.pushdialog;

import atmp;
import audw;
import com.tencent.TMG.utils.QLog;
import java.util.Date;

public class PushDialogDbUtil$2
  implements Runnable
{
  public PushDialogDbUtil$2(audw paramaudw, atmp paramatmp, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void run()
  {
    synchronized (audw.a(this.this$0))
    {
      this.jdField_a_of_type_Atmp.b(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate);
      if (QLog.isColorLevel()) {
        QLog.d("PushDialogDbUtil", 3, "PushDialogTemplate delete: " + new Date(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.time) + "," + this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.mUin + "," + this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.c2c_type);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2
 * JD-Core Version:    0.7.0.1
 */