package com.tencent.mobileqq.c2cshortcutbar;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class C2CShortcutBarAIOHelper$2
  extends C2CShortcutBarObserver
{
  C2CShortcutBarAIOHelper$2(C2CShortcutBarAIOHelper paramC2CShortcutBarAIOHelper) {}
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (C2CShortcutBarAIOHelper.a(this.a) != paramLong) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarObserver", 2, "onRecieveNewC2CShortcutAppListPush");
      }
    } while (!paramBoolean);
    C2CShortcutBarAIOHelper.a(this.a);
  }
  
  protected void a(boolean paramBoolean, long paramLong, List<C2CShortcutAppInfo> paramList)
  {
    if (C2CShortcutBarAIOHelper.a(this.a) != paramLong) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarObserver", 2, "C2CShortcutBarAIOHelper onRequestC2cShortcutAppList");
      }
    } while (!paramBoolean);
    paramList = C2CShortcutBarManager.a(C2CShortcutBarAIOHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Long.valueOf(paramLong));
    C2CShortcutBarAIOHelper.a(this.a).a(paramList);
    this.a.h();
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((C2CShortcutBarAIOHelper.b(this.a) == null) || (C2CShortcutBarAIOHelper.c(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(C2CShortcutBarAIOHelper.d(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {}
    while ((!paramBoolean1) || (!C2CShortcutBarAIOHelper.e(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString))) {
      return;
    }
    if (paramBoolean2)
    {
      this.a.h();
      C2CShortcutBarAIOHelper.a(this.a);
      return;
    }
    this.a.i();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarObserver", 2, "onSetGlobalSwitcherStatus isSuccess = " + paramBoolean1 + ",isGlobalOpen = " + paramBoolean2);
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */