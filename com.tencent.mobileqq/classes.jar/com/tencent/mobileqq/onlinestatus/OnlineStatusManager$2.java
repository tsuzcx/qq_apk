package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import axuy;
import axvi;
import axvk;
import axyi;
import axyt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusManager$2
  implements Runnable
{
  public OnlineStatusManager$2(axvk paramaxvk) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      if (axvk.a(this.this$0) == null)
      {
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "SyncBusinessInfoRunnable app.isRunning=", localObject, " mSyncPause:", Boolean.valueOf(axvk.a(this.this$0)) });
      }
    }
    else if ((axvk.a(this.this$0) != null) && (axvk.a(this.this$0).isRunning()))
    {
      i = axuy.a().a(axvk.a(this.this$0));
      if (i != 1) {
        break label163;
      }
      localObject = axuy.a().a(axvk.a(this.this$0));
      ((axyt)axvk.a(this.this$0).getBusinessHandler(174)).a(i, (Bundle)localObject);
    }
    for (;;)
    {
      this.this$0.c();
      return;
      localObject = Boolean.valueOf(axvk.a(this.this$0).isRunning());
      break;
      label163:
      if (i == 4)
      {
        if (!axvk.a(this.this$0)) {
          this.this$0.a(7);
        }
      }
      else if (i == 3)
      {
        boolean bool1 = axyi.b(axvk.a(this.this$0));
        boolean bool2 = axyi.a(axvk.a(this.this$0));
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusManager", 2, new Object[] { "run: invoked. [constellation] need fetch? ", " type: ", Integer.valueOf(i), " constellationRequestExpired: ", Boolean.valueOf(bool2), " constellationStatus: ", Boolean.valueOf(bool1) });
        }
        if ((bool1) && (bool2))
        {
          localObject = axyi.b(axvk.a(this.this$0), axvk.a(this.this$0).getCurrentAccountUin());
          axvi.a(axvk.a(this.this$0), (String)localObject);
          axyi.a(axvk.a(this.this$0), System.currentTimeMillis() / 1000L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.2
 * JD-Core Version:    0.7.0.1
 */