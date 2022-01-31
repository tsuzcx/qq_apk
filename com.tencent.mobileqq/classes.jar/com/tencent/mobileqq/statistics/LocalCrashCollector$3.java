package com.tencent.mobileqq.statistics;

import ajjy;
import android.support.v4.app.FragmentActivity;
import awqk;
import awql;
import babr;
import bafb;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class LocalCrashCollector$3
  implements Runnable
{
  LocalCrashCollector$3(LocalCrashCollector paramLocalCrashCollector) {}
  
  public void run()
  {
    try
    {
      SessionInfo localSessionInfo = LocalCrashCollector.a(this.this$0).a();
      FragmentActivity localFragmentActivity = LocalCrashCollector.a(this.this$0).a;
      Object localObject;
      String str;
      if (LocalCrashCollector.a(this.this$0) > 0)
      {
        localObject = ajjy.a(2131640466) + localSessionInfo.d;
        if (LocalCrashCollector.a(this.this$0) <= 0) {
          break label183;
        }
        str = "Crash count: " + LocalCrashCollector.a(this.this$0) + "\n" + "CrashInfoSummary.txt";
        label107:
        if (LocalCrashCollector.a(this.this$0) <= 0) {
          break label188;
        }
      }
      label183:
      label188:
      for (int i = 2131625184;; i = 2131629116)
      {
        localObject = babr.a(localFragmentActivity, 230, (String)localObject, str, 2131625035, i, new awqk(this, localSessionInfo), new awql(this));
        ((bafb)localObject).adjustTitle();
        if (LocalCrashCollector.a(this.this$0).a.isFinishing()) {
          return;
        }
        ((bafb)localObject).show();
        return;
        localObject = "0 Crash";
        break;
        str = null;
        break label107;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.3
 * JD-Core Version:    0.7.0.1
 */