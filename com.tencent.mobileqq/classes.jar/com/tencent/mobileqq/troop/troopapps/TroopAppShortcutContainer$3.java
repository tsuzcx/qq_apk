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
  TroopAppShortcutContainer$3(TroopAppShortcutContainer paramTroopAppShortcutContainer) {}
  
  protected void a(long paramLong)
  {
    if (paramLong != TroopAppShortcutContainer.d(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShortcutBarItemUpdated troopCode:");
      localStringBuilder.append(paramLong);
      QLog.e("TroopAppShortcutContainer", 2, localStringBuilder.toString());
    }
    TroopAppShortcutContainer.a(this.a, 1, 0, 3);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetTotalSwitch:");
      ((StringBuilder)localObject).append(String.valueOf(paramLong));
      ((StringBuilder)localObject).append("isSuccess");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("disabled");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("TroopAppShortcutContainer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new AppsAioShortCutViewBuilder(this.a.d, this.a.b, this.a.c, TroopAppShortcutContainer.b(this.a), TroopAppShortcutContainer.c(this.a));
    AppsAioShortCutViewBuilder.AioShortCutInfo localAioShortCutInfo = new AppsAioShortCutViewBuilder.AioShortCutInfo();
    TroopShortcutBarInfo localTroopShortcutBarInfo = ((TroopShortcutBarManager)this.a.b.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(TroopAppShortcutContainer.d(this.a)));
    if (localTroopShortcutBarInfo != null) {
      localAioShortCutInfo.e = localTroopShortcutBarInfo;
    }
    localAioShortCutInfo.b = TroopAppShortcutUtils.a(this.a.b, TroopAppShortcutContainer.d(this.a));
    boolean bool2 = true;
    boolean bool1 = true;
    if (!paramBoolean)
    {
      if (paramInt != 0) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      localAioShortCutInfo.a = paramBoolean;
    }
    else
    {
      if (paramInt == 0) {
        paramBoolean = bool2;
      } else {
        paramBoolean = false;
      }
      localAioShortCutInfo.a = paramBoolean;
    }
    TroopAppShortcutUtils.a(this.a.b, localAioShortCutInfo, TroopAppShortcutContainer.d(this.a));
    ((AppsBaseBuilder)localObject).a_(localAioShortCutInfo);
    this.a.j.a(0, (AppsBaseBuilder)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.3
 * JD-Core Version:    0.7.0.1
 */