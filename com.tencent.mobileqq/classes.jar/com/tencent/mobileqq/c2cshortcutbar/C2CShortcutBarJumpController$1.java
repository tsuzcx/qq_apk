package com.tencent.mobileqq.c2cshortcutbar;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreController.IStoreItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class C2CShortcutBarJumpController$1
  implements C2CShortcutBarStoreController.IStoreItemClickListener
{
  C2CShortcutBarJumpController$1(C2CShortcutBarJumpController paramC2CShortcutBarJumpController, BaseChatPie paramBaseChatPie) {}
  
  public void a(int paramInt, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarJumpController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramC2CShortcutAppInfo, false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B32D", "0X800B32D", C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, paramC2CShortcutAppInfo.a, paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController.1
 * JD-Core Version:    0.7.0.1
 */