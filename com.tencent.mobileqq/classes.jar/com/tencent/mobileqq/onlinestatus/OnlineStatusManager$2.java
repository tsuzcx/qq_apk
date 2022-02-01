package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import ayox;
import ayph;
import aypj;
import aysh;
import ayta;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusManager$2
  implements Runnable
{
  public OnlineStatusManager$2(aypj paramaypj) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      if (aypj.a(this.this$0) == null)
      {
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "SyncBusinessInfoRunnable app.isRunning=", localObject, " mSyncPause:", Boolean.valueOf(aypj.a(this.this$0)) });
      }
    }
    else if ((aypj.a(this.this$0) != null) && (aypj.a(this.this$0).isRunning()))
    {
      i = ayox.a().a(aypj.a(this.this$0));
      if (i != 1) {
        break label163;
      }
      localObject = ayox.a().a(aypj.a(this.this$0));
      ((ayta)aypj.a(this.this$0).a(174)).a(i, (Bundle)localObject);
    }
    for (;;)
    {
      this.this$0.c();
      return;
      localObject = Boolean.valueOf(aypj.a(this.this$0).isRunning());
      break;
      label163:
      if (i == 4)
      {
        if (!aypj.a(this.this$0)) {
          this.this$0.a(7);
        }
      }
      else if (i == 3)
      {
        boolean bool1 = aysh.b(aypj.a(this.this$0));
        boolean bool2 = aysh.a(aypj.a(this.this$0));
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusManager", 2, new Object[] { "run: invoked. [constellation] need fetch? ", " type: ", Integer.valueOf(i), " constellationRequestExpired: ", Boolean.valueOf(bool2), " constellationStatus: ", Boolean.valueOf(bool1) });
        }
        if ((bool1) && (bool2))
        {
          localObject = aysh.b(aypj.a(this.this$0), aypj.a(this.this$0).getCurrentAccountUin());
          ayph.a(aypj.a(this.this$0), (String)localObject);
          aysh.a(aypj.a(this.this$0), System.currentTimeMillis() / 1000L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusManager.2
 * JD-Core Version:    0.7.0.1
 */