package com.tencent.timi.game.base;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TimiGameActivityManager
{
  public static QBaseActivity a()
  {
    return QBaseActivity.sTopActivity;
  }
  
  public static TimiGameBaseActivity b()
  {
    QBaseActivity localQBaseActivity = a();
    if ((localQBaseActivity instanceof TimiGameBaseActivity)) {
      return (TimiGameBaseActivity)localQBaseActivity;
    }
    return null;
  }
  
  public static AppRuntime c()
  {
    Object localObject = a();
    if (localObject != null) {
      localObject = ((QBaseActivity)localObject).getAppRuntime();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.getAppRuntime(((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).b());
        localObject = localAppRuntime;
        Logger.a("TimiGameActivityManager_", "appRuntime from sMobileQQ");
        return localAppRuntime;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        Logger.a("TimiGameActivityManager_", "getAppRuntime failed", localAccountNotMatchException);
        return localObject;
      }
    }
    Logger.a("TimiGameActivityManager_", "appRuntime from topActivity");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.base.TimiGameActivityManager
 * JD-Core Version:    0.7.0.1
 */