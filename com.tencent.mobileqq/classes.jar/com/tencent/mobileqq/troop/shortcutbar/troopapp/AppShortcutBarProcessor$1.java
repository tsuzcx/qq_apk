package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarConfig;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver;
import com.tencent.qphone.base.util.QLog;

class AppShortcutBarProcessor$1
  extends TroopShortcutBarObserver
{
  AppShortcutBarProcessor$1(AppShortcutBarProcessor paramAppShortcutBarProcessor, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        if ((paramLong != AppShortcutBarProcessor.a(this.a)) || (AppShortcutBarProcessor.a(this.a).I)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated.");
        }
        TroopInfo localTroopInfo = ((TroopManager)AppShortcutBarProcessor.a(this.a).a.getManager(QQManagerFactory.TROOP_MANAGER)).b(AppShortcutBarProcessor.a(this.a));
        if (localTroopInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
          }
          Object localObject1 = (TroopShortcutBarManager)AppShortcutBarProcessor.a(this.a).a.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
          if (localObject1 != null)
          {
            localObject1 = ((TroopShortcutBarManager)localObject1).a(Long.valueOf(AppShortcutBarProcessor.a(this.a)));
            if (localObject1 != null)
            {
              ((TroopShortcutBarInfo)localObject1).d(0);
              ((TroopShortcutBarInfo)localObject1).a(0L);
            }
            localObject1 = (TroopShortcutBarHandler)AppShortcutBarProcessor.a(this.a).a.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
            if (localObject1 == null) {
              break;
            }
            ((TroopShortcutBarHandler)localObject1).a(AppShortcutBarProcessor.a(this.a), (int)localTroopInfo.dwGroupClassExt, null);
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated. TroopInfo is null!");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = null;
    if (!paramBoolean) {}
    try
    {
      if (!QLog.isColorLevel()) {
        break label378;
      }
      QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo Fail");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
      return;
    }
    TroopShortcutBarInfo localTroopShortcutBarInfo;
    int i;
    if ((paramLong == AppShortcutBarProcessor.a(this.a)) && (!AppShortcutBarProcessor.a(this.a).I))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo.");
      }
      if ((AppShortcutBarProcessor.a(this.a) != null) && (AppShortcutBarProcessor.a(this.a).a != null))
      {
        TroopInfo localTroopInfo = ((TroopManager)AppShortcutBarProcessor.a(this.a).a.getManager(QQManagerFactory.TROOP_MANAGER)).b(AppShortcutBarProcessor.a(this.a));
        if (localTroopInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarProcessor", 2, "updateAppShortcutPanel. troopInfo is null.");
          }
        }
        else
        {
          TroopShortcutBarConfig localTroopShortcutBarConfig = (TroopShortcutBarConfig)QConfigManager.a().a(590);
          if ((localTroopShortcutBarConfig != null) && (localTroopInfo != null) && ((localTroopShortcutBarConfig.a((int)localTroopInfo.dwGroupClassExt)) || (localTroopShortcutBarConfig.b((int)localTroopInfo.dwGroupClassExt))))
          {
            TroopShortcutBarManager localTroopShortcutBarManager = (TroopShortcutBarManager)AppShortcutBarProcessor.a(this.a).a.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
            if (localTroopShortcutBarManager != null) {
              localTroopShortcutBarInfo = localTroopShortcutBarManager.a(Long.valueOf(AppShortcutBarProcessor.a(this.a)));
            }
            if (localTroopInfo.isAdmin()) {
              break label379;
            }
            if (!localTroopInfo.isTroopOwner(AppShortcutBarProcessor.a(this.a).a.getCurrentAccountUin())) {
              break label385;
            }
            break label379;
            if (i != 0) {
              break label396;
            }
            if (localTroopShortcutBarConfig.a != TroopShortcutBarConfig.c) {
              break label391;
            }
            paramBoolean = true;
          }
        }
      }
    }
    for (;;)
    {
      if ((localTroopShortcutBarInfo != null) && (((i == 0) && (localTroopShortcutBarInfo.a() == 0)) || ((i != 0) && (localTroopShortcutBarInfo.b() == 0))))
      {
        AppShortcutBarProcessor.a(this.a).a(0, AppShortcutBarProcessor.a(this.a, localTroopShortcutBarInfo.a()), paramBoolean);
        return;
      }
      AppShortcutBarProcessor.a(this.a).a(0, null, paramBoolean);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo. Noting To Do!");
      }
      label378:
      return;
      label379:
      i = 1;
      break;
      label385:
      i = 0;
      break;
      label391:
      paramBoolean = false;
      continue;
      label396:
      paramBoolean = true;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (AppShortcutBarProcessor.a(this.a) == null) || (AppShortcutBarProcessor.a(this.a).I)) {
      return;
    }
    Object localObject = (TroopShortcutBarManager)AppShortcutBarProcessor.a(this.a).a.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
    if ((localObject != null) && (((TroopShortcutBarManager)localObject).a()))
    {
      ((TroopShortcutBarManager)localObject).a(false);
      localObject = ((TroopShortcutBarManager)localObject).a(Long.valueOf(AppShortcutBarProcessor.a(this.a)));
      if (localObject != null)
      {
        ((TroopShortcutBarInfo)localObject).c(0);
        ((TroopShortcutBarInfo)localObject).a(0L);
        ((TroopShortcutBarInfo)localObject).d(0);
      }
    }
    AppShortcutBarProcessor.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor.1
 * JD-Core Version:    0.7.0.1
 */