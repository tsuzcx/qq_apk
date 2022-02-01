package com.tencent.mobileqq.onlinestatus.manager;

import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatus;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;

class AutoStatusManager$5
  extends OnlineStatusObserver
{
  AutoStatusManager$5(AutoStatusManager paramAutoStatusManager) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      long l1 = OnLineStatusHelper.a().a(AutoStatusManager.a(this.a));
      if (l1 > 40000L)
      {
        if (AutoStatusManager.f(this.a))
        {
          long l2 = paramBundle.getLong("autoStatusInterval");
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("[status][autoMgr] onSetOnlineStatus status: ");
            paramBundle.append(Constant.c((int)l1));
            paramBundle.append(" autoStatusInterval: ");
            paramBundle.append(l2);
            QLog.d("AutoStatusManager", 2, paramBundle.toString());
          }
          if (l2 > 60L) {
            AutoStatusManager.a(this.a, Constant.a((int)l2));
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("[status][autoMgr] onSetOnlineStatus status: ");
            paramBundle.append(Constant.c((int)l1));
            paramBundle.append(" startDetector");
            QLog.d("AutoStatusManager", 2, paramBundle.toString());
          }
          AutoStatusManager.g(this.a).a((int)l1);
          this.a.a("statusChange");
        }
      }
      else if (AutoStatusManager.f(this.a))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("[status][autoMgr] onSetOnlineStatus status: ");
          paramBundle.append(Constant.c((int)l1));
          paramBundle.append(" stopDetector");
          QLog.d("AutoStatusManager", 2, paramBundle.toString());
        }
        this.a.b("statusChange");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager.5
 * JD-Core Version:    0.7.0.1
 */