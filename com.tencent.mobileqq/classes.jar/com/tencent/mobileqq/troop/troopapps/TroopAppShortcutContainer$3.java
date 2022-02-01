package com.tencent.mobileqq.troop.troopapps;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.qphone.base.util.QLog;

class TroopAppShortcutContainer$3
  extends TroopShortcutBarObserver
{
  TroopAppShortcutContainer$3(TroopAppShortcutContainer paramTroopAppShortcutContainer, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(long paramLong)
  {
    if (paramLong != TroopAppShortcutContainer.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutContainer", 2, "onShortcutBarItemUpdated troopCode:" + paramLong);
    }
    TroopAppShortcutContainer.a(this.a, 1, 0, 3);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutContainer", 2, "onSetTotalSwitch:" + String.valueOf(paramLong) + "isSuccess" + paramBoolean + "disabled" + paramInt);
    }
    AppsAioShortCutViewBuilder localAppsAioShortCutViewBuilder = new AppsAioShortCutViewBuilder(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, TroopAppShortcutContainer.a(this.a), TroopAppShortcutContainer.a(this.a));
    AppsAioShortCutViewBuilder.AioShortCutInfo localAioShortCutInfo = new AppsAioShortCutViewBuilder.AioShortCutInfo();
    TroopShortcutBarInfo localTroopShortcutBarInfo = ((TroopShortcutBarManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(TroopAppShortcutContainer.a(this.a)));
    if (localTroopShortcutBarInfo != null) {
      localAioShortCutInfo.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarInfo = localTroopShortcutBarInfo;
    }
    localAioShortCutInfo.b = TroopAppShortcutUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopAppShortcutContainer.a(this.a));
    if (!paramBoolean)
    {
      if (paramInt != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localAioShortCutInfo.jdField_a_of_type_Boolean = paramBoolean;
        TroopAppShortcutUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localAioShortCutInfo, TroopAppShortcutContainer.a(this.a));
        localAppsAioShortCutViewBuilder.a_(localAioShortCutInfo);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$AppsListViewAdapter.a(0, localAppsAioShortCutViewBuilder);
        return;
      }
    }
    if (paramInt == 0) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localAioShortCutInfo.jdField_a_of_type_Boolean = paramBoolean;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.3
 * JD-Core Version:    0.7.0.1
 */