package com.tencent.mobileqq.managers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;

class TempMsgManager$2
  implements DialogInterface.OnClickListener
{
  TempMsgManager$2(TempMsgManager paramTempMsgManager, BaseChatPie paramBaseChatPie, short paramShort) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(1);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.a(this.jdField_a_of_type_Short, true, true);
        ReportController.b(TempMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager), "dc00898", "", "", "0X8009978", "0X8009978", this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.a(this.jdField_a_of_type_Short), this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.a(this.jdField_a_of_type_Short), "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TempMsgManager.2
 * JD-Core Version:    0.7.0.1
 */