package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.qphone.base.util.QLog;

class OnlineStatusManager$2
  implements Runnable
{
  OnlineStatusManager$2(OnlineStatusManager paramOnlineStatusManager) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      if (OnlineStatusManager.a(this.this$0) == null)
      {
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "SyncBusinessInfoRunnable app.isRunning=", localObject, " mSyncPause:", Boolean.valueOf(OnlineStatusManager.a(this.this$0)) });
      }
    }
    else if ((OnlineStatusManager.a(this.this$0) != null) && (OnlineStatusManager.a(this.this$0).isRunning()))
    {
      i = OnLineStatusHelper.a().a(OnlineStatusManager.a(this.this$0));
      if (i != 1) {
        break label163;
      }
      localObject = OnLineStatusHelper.a().a(OnlineStatusManager.a(this.this$0));
      ((OnlineStatusHandler)OnlineStatusManager.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.ONLINE_STATUS_HANDLER)).a(i, (Bundle)localObject);
    }
    for (;;)
    {
      this.this$0.c();
      return;
      localObject = Boolean.valueOf(OnlineStatusManager.a(this.this$0).isRunning());
      break;
      label163:
      if (i == 4)
      {
        if (!OnlineStatusManager.a(this.this$0)) {
          this.this$0.a(7);
        }
      }
      else if (i == 3)
      {
        boolean bool1 = ConstellationUtilKt.b(OnlineStatusManager.a(this.this$0));
        boolean bool2 = ConstellationUtilKt.a(OnlineStatusManager.a(this.this$0));
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusManager", 2, new Object[] { "run: invoked. [constellation] need fetch? ", " type: ", Integer.valueOf(i), " constellationRequestExpired: ", Boolean.valueOf(bool2), " constellationStatus: ", Boolean.valueOf(bool1) });
        }
        if ((bool1) && (bool2))
        {
          localObject = ConstellationUtilKt.b(OnlineStatusManager.a(this.this$0), OnlineStatusManager.a(this.this$0).getCurrentAccountUin());
          OnlineStatusExtInfoServlet.a(OnlineStatusManager.a(this.this$0), (String)localObject);
          ConstellationUtilKt.a(OnlineStatusManager.a(this.this$0), System.currentTimeMillis() / 1000L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.2
 * JD-Core Version:    0.7.0.1
 */