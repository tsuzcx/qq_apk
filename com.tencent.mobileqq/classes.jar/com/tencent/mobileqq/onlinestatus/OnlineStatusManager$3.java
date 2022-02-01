package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import mqq.app.AppRuntime.Status;

class OnlineStatusManager$3
  implements StudyModeChangeListener
{
  OnlineStatusManager$3(OnlineStatusManager paramOnlineStatusManager) {}
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) || (OnlineStatusManager.a(this.a).getOnlineStatus() != AppRuntime.Status.online)) {}
    while (OnLineStatusHelper.a().a(AppRuntime.Status.online, OnlineStatusManager.a(this.a).getExtOnlineStatus(), false).a) {
      return;
    }
    OnlineStatusManager.a(this.a).updateOnlineStatus(AppRuntime.Status.online, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.3
 * JD-Core Version:    0.7.0.1
 */