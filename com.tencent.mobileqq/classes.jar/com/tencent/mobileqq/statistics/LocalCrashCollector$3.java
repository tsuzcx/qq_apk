package com.tencent.mobileqq.statistics;

import ajyc;
import android.support.v4.app.FragmentActivity;
import axqj;
import axqk;
import bbcv;
import bbgg;
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
        localObject = ajyc.a(2131706251) + localSessionInfo.d;
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
      for (int i = 2131690745;; i = 2131694793)
      {
        localObject = bbcv.a(localFragmentActivity, 230, (String)localObject, str, 2131690596, i, new axqj(this, localSessionInfo), new axqk(this));
        ((bbgg)localObject).adjustTitle();
        if (LocalCrashCollector.a(this.this$0).a.isFinishing()) {
          return;
        }
        ((bbgg)localObject).show();
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