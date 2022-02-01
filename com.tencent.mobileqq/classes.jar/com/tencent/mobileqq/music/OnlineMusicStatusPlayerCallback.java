package com.tencent.mobileqq.music;

import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;

public class OnlineMusicStatusPlayerCallback
  implements IQQPlayerLifeCycleCallback
{
  public void a(AppService paramAppService)
  {
    paramAppService = (IQQPlayer)QRoute.api(IQQPlayer.class);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineMusicStatusPlayer", 2, "[onCreate]");
    }
    IOnlineMusicStatusManager localIOnlineMusicStatusManager = (IOnlineMusicStatusManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class);
    if (localIOnlineMusicStatusManager != null) {
      paramAppService.addCallback(localIOnlineMusicStatusManager.b());
    }
  }
  
  public void b(AppService paramAppService)
  {
    paramAppService = (IQQPlayer)QRoute.api(IQQPlayer.class);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineMusicStatusPlayer", 2, "[onDestroy]");
    }
    IOnlineMusicStatusManager localIOnlineMusicStatusManager = (IOnlineMusicStatusManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class);
    if (localIOnlineMusicStatusManager != null) {
      paramAppService.removeCallback(localIOnlineMusicStatusManager.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.OnlineMusicStatusPlayerCallback
 * JD-Core Version:    0.7.0.1
 */