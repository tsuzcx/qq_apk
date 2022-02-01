package com.tencent.mobileqq.onlinestatus.auto;

import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.qphone.base.util.QLog;

class AutoStatusManager$5
  extends OnlineStatusObserver
{
  AutoStatusManager$5(AutoStatusManager paramAutoStatusManager) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    long l1;
    if (paramBoolean)
    {
      l1 = OnLineStatusHelper.a().a(AutoStatusManager.a(this.a));
      if (l1 <= 40000L) {
        break label176;
      }
      if (!AutoStatusManager.a(this.a)) {
        break label114;
      }
      l2 = paramBundle.getLong("autoStatusInterval");
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] onSetOnlineStatus status: " + Constant.a((int)l1) + " autoStatusInterval: " + l2);
      }
      if (l2 > 60L) {
        AutoStatusManager.a(this.a, Constant.a((int)l2));
      }
    }
    label114:
    while (!AutoStatusManager.a(this.a))
    {
      long l2;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] onSetOnlineStatus status: " + Constant.a((int)l1) + " startDetector");
      }
      AutoStatusManager.a(this.a).a((int)l1);
      this.a.a("statusChange");
      return;
    }
    label176:
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] onSetOnlineStatus status: " + Constant.a((int)l1) + " stopDetector");
    }
    this.a.b("statusChange");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.5
 * JD-Core Version:    0.7.0.1
 */