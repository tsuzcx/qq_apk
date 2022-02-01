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
        BaseSessionInfo localBaseSessionInfo = LocalCrashCollector.a(this.this$0).a();
        BaseActivity localBaseActivity = LocalCrashCollector.a(this.this$0).a();
        if (LocalCrashCollector.a(this.this$0) <= 0) {
          break label208;
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131706338));
        ((StringBuilder)localObject1).append(localBaseSessionInfo.d);
        localObject1 = ((StringBuilder)localObject1).toString();
        if (LocalCrashCollector.a(this.this$0) <= 0) {
          break label214;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Crash count: ");
        ((StringBuilder)localObject2).append(LocalCrashCollector.a(this.this$0));
        ((StringBuilder)localObject2).append("\n");
        ((StringBuilder)localObject2).append("CrashInfoSummary.txt");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (LocalCrashCollector.a(this.this$0) <= 0) {
          break label219;
        }
        i = 2131690820;
        localObject1 = DialogUtil.a(localBaseActivity, 230, (String)localObject1, (String)localObject2, 2131690728, i, new LocalCrashCollector.3.1(this, localBaseSessionInfo), new LocalCrashCollector.3.2(this));
        ((QQCustomDialog)localObject1).adjustTitle();
        if (!LocalCrashCollector.a(this.this$0).a().isFinishing())
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
      int i = 2131694583;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.3
 * JD-Core Version:    0.7.0.1
 */