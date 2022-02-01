package com.tencent.mobileqq.troop.shortcutbar.troopapp;

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
import mqq.app.AppRuntime;

class AppShortcutBarProcessor$1
  extends TroopShortcutBarObserver
{
  AppShortcutBarProcessor$1(AppShortcutBarProcessor paramAppShortcutBarProcessor) {}
  
  protected void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        if (paramLong == AppShortcutBarProcessor.a(this.a))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated.");
          }
          TroopInfo localTroopInfo = ((TroopManager)AppShortcutBarProcessor.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).b(AppShortcutBarProcessor.a(this.a));
          if (localTroopInfo != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
            }
            Object localObject1 = (TroopShortcutBarManager)AppShortcutBarProcessor.a(this.a).getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
            if (localObject1 == null) {
              break label196;
            }
            localObject1 = ((TroopShortcutBarManager)localObject1).a(Long.valueOf(AppShortcutBarProcessor.a(this.a)));
            if (localObject1 != null)
            {
              ((TroopShortcutBarInfo)localObject1).d(0);
              ((TroopShortcutBarInfo)localObject1).a(0L);
            }
            localObject1 = (TroopShortcutBarHandler)((QQAppInterface)AppShortcutBarProcessor.a(this.a)).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
            if (localObject1 != null) {
              ((TroopShortcutBarHandler)localObject1).a(AppShortcutBarProcessor.a(this.a), (int)localTroopInfo.dwGroupClassExt, null);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("AppShortcutBarProcessor", 2, "onShortcutBarItemUpdated. TroopInfo is null!");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
      }
      return;
      label196:
      Object localObject2 = null;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    label228:
    int i;
    try
    {
      if (!QLog.isColorLevel()) {
        break label346;
      }
      QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo Fail");
      return;
    }
    catch (Exception localException)
    {
      TroopInfo localTroopInfo;
      TroopShortcutBarConfig localTroopShortcutBarConfig;
      Object localObject1;
      QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
    }
    if (paramLong == AppShortcutBarProcessor.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo.");
      }
      if (AppShortcutBarProcessor.a(this.a) == null) {
        return;
      }
      localTroopInfo = ((TroopManager)AppShortcutBarProcessor.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).b(AppShortcutBarProcessor.a(this.a));
      if (localTroopInfo == null)
      {
        if (!QLog.isColorLevel()) {
          break label347;
        }
        QLog.e("AppShortcutBarProcessor", 2, "updateAppShortcutPanel. troopInfo is null.");
        return;
      }
      localTroopShortcutBarConfig = (TroopShortcutBarConfig)QConfigManager.a().a(590);
      if ((localTroopShortcutBarConfig != null) && (localTroopInfo != null) && ((localTroopShortcutBarConfig.a((int)localTroopInfo.dwGroupClassExt)) || (localTroopShortcutBarConfig.b((int)localTroopInfo.dwGroupClassExt))))
      {
        localObject1 = (TroopShortcutBarManager)AppShortcutBarProcessor.a(this.a).getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
        if (localObject1 == null) {
          break label348;
        }
        localObject1 = ((TroopShortcutBarManager)localObject1).a(Long.valueOf(AppShortcutBarProcessor.a(this.a)));
        if (localTroopInfo.isAdmin()) {
          break label360;
        }
        if (!localTroopInfo.isTroopOwner(AppShortcutBarProcessor.a(this.a).getCurrentAccountUin())) {
          break label354;
        }
        break label360;
        if (i != 0) {
          break label371;
        }
        if (localTroopShortcutBarConfig.a != TroopShortcutBarConfig.c) {
          break label366;
        }
        break label371;
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((i == 0) && (((TroopShortcutBarInfo)localObject1).a() == 0)) || ((i != 0) && (((TroopShortcutBarInfo)localObject1).b() == 0))))
      {
        AppShortcutBarProcessor.a(this.a).a(0, AppShortcutBarProcessor.a(this.a, ((TroopShortcutBarInfo)localObject1).a()), paramBoolean);
        return;
      }
      AppShortcutBarProcessor.a(this.a).a(0, null, paramBoolean);
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("AppShortcutBarProcessor", 2, "onGetAIOShortcutBarInfo. Noting To Do!");
        return;
      }
      return;
      label346:
      return;
      label347:
      return;
      label348:
      Object localObject2 = null;
      break;
      label354:
      i = 0;
      break label228;
      label360:
      i = 1;
      break label228;
      label366:
      paramBoolean = false;
      continue;
      label371:
      paramBoolean = true;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (AppShortcutBarProcessor.a(this.a) == null) {
        return;
      }
      Object localObject = (TroopShortcutBarManager)AppShortcutBarProcessor.a(this.a).getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor.1
 * JD-Core Version:    0.7.0.1
 */