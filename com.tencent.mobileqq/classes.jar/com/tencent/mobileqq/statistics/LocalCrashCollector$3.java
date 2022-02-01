package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class LocalCrashCollector$3
  implements Runnable
{
  LocalCrashCollector$3(LocalCrashCollector paramLocalCrashCollector) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        BaseSessionInfo localBaseSessionInfo = LocalCrashCollector.a(this.this$0).O();
        BaseActivity localBaseActivity = LocalCrashCollector.a(this.this$0).b();
        if (LocalCrashCollector.b(this.this$0) <= 0) {
          break label208;
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904197));
        ((StringBuilder)localObject1).append(localBaseSessionInfo.e);
        localObject1 = ((StringBuilder)localObject1).toString();
        if (LocalCrashCollector.b(this.this$0) <= 0) {
          break label214;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Crash count: ");
        ((StringBuilder)localObject2).append(LocalCrashCollector.b(this.this$0));
        ((StringBuilder)localObject2).append("\n");
        ((StringBuilder)localObject2).append("CrashInfoSummary.txt");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (LocalCrashCollector.b(this.this$0) <= 0) {
          break label219;
        }
        i = 2131887750;
        localObject1 = DialogUtil.a(localBaseActivity, 230, (String)localObject1, (String)localObject2, 2131887648, i, new LocalCrashCollector.3.1(this, localBaseSessionInfo), new LocalCrashCollector.3.2(this));
        ((QQCustomDialog)localObject1).adjustTitle();
        if (!LocalCrashCollector.a(this.this$0).b().isFinishing())
        {
          ((QQCustomDialog)localObject1).show();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label208:
      String str = "0 Crash";
      continue;
      label214:
      Object localObject2 = null;
      continue;
      label219:
      int i = 2131892267;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.3
 * JD-Core Version:    0.7.0.1
 */