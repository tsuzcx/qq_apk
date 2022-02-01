package com.tencent.mobileqq.upgrade;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

class NewUpgradeDialog$6
  implements Runnable
{
  NewUpgradeDialog$6(NewUpgradeDialog paramNewUpgradeDialog) {}
  
  public void run()
  {
    long l = 1500L / 10;
    int i = 10;
    while (i > 0)
    {
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.6.1(this, (10 - i) * 10));
      i -= 1;
      try
      {
        TimeUnit.MILLISECONDS.sleep(l);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    if (!NewUpgradeDialog.a(this.this$0)) {
      NewUpgradeDialog.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog.6
 * JD-Core Version:    0.7.0.1
 */