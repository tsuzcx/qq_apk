package com.tencent.mobileqq.upgrade;

import bgvp;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class NewUpgradeDialog$6
  implements Runnable
{
  public NewUpgradeDialog$6(bgvp parambgvp) {}
  
  public void run()
  {
    int i = 10;
    long l = 1500L / 10;
    for (;;)
    {
      if (i > 0)
      {
        ThreadManager.getUIHandler().post(new NewUpgradeDialog.6.1(this, (10 - i) * 10));
        try
        {
          TimeUnit.MILLISECONDS.sleep(l);
          i -= 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    if (!bgvp.a(this.this$0)) {
      bgvp.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog.6
 * JD-Core Version:    0.7.0.1
 */