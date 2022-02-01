package com.tencent.mobileqq.pushdialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;

class AIOPushDialogHelper$3
  implements DialogInterface.OnClickListener
{
  AIOPushDialogHelper$3(AIOPushDialogHelper paramAIOPushDialogHelper, String paramString, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new HttpMqqJumper(AIOPushDialogHelper.a(this.jdField_a_of_type_ComTencentMobileqqPushdialogAIOPushDialogHelper).jdField_a_of_type_AndroidContentContext, AIOPushDialogHelper.a(this.jdField_a_of_type_ComTencentMobileqqPushdialogAIOPushDialogHelper).a()).a(this.jdField_a_of_type_JavaLangString).a(AIOPushDialogHelper.a(this.jdField_a_of_type_ComTencentMobileqqPushdialogAIOPushDialogHelper).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo).a(AIOPushDialogHelper.a(this.jdField_a_of_type_ComTencentMobileqqPushdialogAIOPushDialogHelper)).a();
    if (this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate.isFriendBanned())
    {
      ReportController.b(AIOPushDialogHelper.a(this.jdField_a_of_type_ComTencentMobileqqPushdialogAIOPushDialogHelper).a(), "dc00898", "", "", "0X800A4BE", "0X800A4BE", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(AIOPushDialogHelper.a(this.jdField_a_of_type_ComTencentMobileqqPushdialogAIOPushDialogHelper).a(), "dc00898", "", "", "0X800A4BC", "0X800A4BC", 0, 0, "", "", "", "");
    ReportController.b(AIOPushDialogHelper.a(this.jdField_a_of_type_ComTencentMobileqqPushdialogAIOPushDialogHelper), "dc00898", "", "", "0X800B9A2", "0X800B9A2", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.AIOPushDialogHelper.3
 * JD-Core Version:    0.7.0.1
 */