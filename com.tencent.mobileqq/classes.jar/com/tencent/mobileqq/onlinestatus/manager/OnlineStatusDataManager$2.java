package com.tencent.mobileqq.onlinestatus.manager;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import mqq.app.AppRuntime.Status;

class OnlineStatusDataManager$2
  implements StudyModeChangeListener
{
  OnlineStatusDataManager$2(OnlineStatusDataManager paramOnlineStatusDataManager) {}
  
  public void onChange(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)OnlineStatusDataManager.a(this.a).getRuntimeService(IOnlineStatusService.class, "");
      if (localIOnlineStatusService.getOnlineStatus() != AppRuntime.Status.online) {
        return;
      }
      if (!OnLineStatusHelper.a().a(AppRuntime.Status.online, localIOnlineStatusService.getExtOnlineStatus(), false).a) {
        localIOnlineStatusService.updateOnlineStatus(AppRuntime.Status.online, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager.2
 * JD-Core Version:    0.7.0.1
 */