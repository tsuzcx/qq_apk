package com.tencent.mobileqq.pushdialog;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class PushDialogHandler$1
  implements Runnable
{
  PushDialogHandler$1(PushDialogHandler paramPushDialogHandler, BaseChatPie paramBaseChatPie, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void run()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate != null)) {
      ((AIOPushDialogHelper)localBaseChatPie.a(42)).a(this.jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogTemplate, 102, 101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogHandler.1
 * JD-Core Version:    0.7.0.1
 */