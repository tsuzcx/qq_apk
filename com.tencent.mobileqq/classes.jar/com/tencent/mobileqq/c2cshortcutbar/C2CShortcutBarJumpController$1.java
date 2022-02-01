package com.tencent.mobileqq.c2cshortcutbar;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreController.IStoreItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class C2CShortcutBarJumpController$1
  implements C2CShortcutBarStoreController.IStoreItemClickListener
{
  C2CShortcutBarJumpController$1(C2CShortcutBarJumpController paramC2CShortcutBarJumpController, Activity paramActivity, AIOShortcutBarContext paramAIOShortcutBarContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void a(int paramInt, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarJumpController.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramC2CShortcutAppInfo, false);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = C2CShortcutBarManager.a(localQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramC2CShortcutAppInfo = paramC2CShortcutAppInfo.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B32D", "0X800B32D", i, 0, paramC2CShortcutAppInfo, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController.1
 * JD-Core Version:    0.7.0.1
 */