package com.tencent.mobileqq.onlinestatus.manager;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.qphone.base.util.QLog;

class OnlineStatusDataManager$3
  implements Runnable
{
  OnlineStatusDataManager$3(OnlineStatusDataManager paramOnlineStatusDataManager) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (OnlineStatusDataManager.a(this.this$0) == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(OnlineStatusDataManager.a(this.this$0).isRunning());
      }
      QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "SyncBusinessInfoRunnable app.isRunning=", localObject, " mSyncPause:", Boolean.valueOf(OnlineStatusDataManager.a(this.this$0)) });
    }
    if ((OnlineStatusDataManager.a(this.this$0) != null) && (OnlineStatusDataManager.a(this.this$0).isRunning()))
    {
      int i = OnLineStatusHelper.a().a(OnlineStatusDataManager.a(this.this$0));
      if (i == 1)
      {
        localObject = OnLineStatusHelper.a().a(OnlineStatusDataManager.a(this.this$0));
        ((OnlineStatusHandler)OnlineStatusDataManager.a(this.this$0).getBusinessHandler(OnlineStatusHandler.class.getName())).a(i, (Bundle)localObject);
      }
      else if (i == 4)
      {
        if (!OnlineStatusDataManager.a(this.this$0)) {
          this.this$0.a(7);
        }
      }
      else if (i == 3)
      {
        boolean bool1 = ConstellationUtilKt.b(OnlineStatusDataManager.a(this.this$0));
        boolean bool2 = ConstellationUtilKt.a(OnlineStatusDataManager.a(this.this$0));
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusDataManagerImpl", 2, new Object[] { "run: invoked. [constellation] need fetch? ", " type: ", Integer.valueOf(i), " constellationRequestExpired: ", Boolean.valueOf(bool2), " constellationStatus: ", Boolean.valueOf(bool1) });
        }
        if ((bool1) && (bool2))
        {
          localObject = ConstellationUtilKt.b(OnlineStatusDataManager.a(this.this$0), OnlineStatusDataManager.a(this.this$0).getCurrentAccountUin());
          OnlineStatusExtInfoServlet.a(OnlineStatusDataManager.a(this.this$0), (String)localObject);
          ConstellationUtilKt.a(OnlineStatusDataManager.a(this.this$0), System.currentTimeMillis() / 1000L);
        }
      }
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager.3
 * JD-Core Version:    0.7.0.1
 */