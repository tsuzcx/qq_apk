package com.tencent.mobileqq.managers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

class TempMsgManager$1
  implements DialogInterface.OnCancelListener
{
  TempMsgManager$1(TempMsgManager paramTempMsgManager, BaseChatPie paramBaseChatPie) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "dialog cancel");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TempMsgManager.1
 * JD-Core Version:    0.7.0.1
 */