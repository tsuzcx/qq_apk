package com.tencent.mobileqq.pushdialog;

import aukn;
import avdc;
import com.tencent.TMG.utils.QLog;
import java.util.Date;

public class PushDialogDbUtil$2
  implements Runnable
{
  public PushDialogDbUtil$2(avdc paramavdc, aukn paramaukn, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void run()
  {
    synchronized (avdc.a(this.this$0))
    {
      this.jdField_a_of_type_Aukn.b(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate);
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