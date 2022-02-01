package com.tencent.mobileqq.statistics;

import amtj;
import android.support.v4.app.FragmentActivity;
import bcds;
import bcdt;
import bfur;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class LocalCrashCollector$3
  implements Runnable
{
  LocalCrashCollector$3(LocalCrashCollector paramLocalCrashCollector) {}
  
  public void run()
  {
    try
    {
      SessionInfo localSessionInfo = LocalCrashCollector.a(this.this$0).getSessionInfo();
      FragmentActivity localFragmentActivity = LocalCrashCollector.a(this.this$0).mActivity;
      Object localObject;
      String str;
      if (LocalCrashCollector.a(this.this$0) > 0)
      {
        localObject = amtj.a(2131705393) + localSessionInfo.curFriendNick;
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
      for (int i = 2131690709;; i = 2131694201)
      {
        localObject = bfur.a(localFragmentActivity, 230, (String)localObject, str, 2131690620, i, new bcds(this, localSessionInfo), new bcdt(this));
        ((QQCustomDialog)localObject).adjustTitle();
        if (LocalCrashCollector.a(this.this$0).mActivity.isFinishing()) {
          return;
        }
        ((QQCustomDialog)localObject).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.3
 * JD-Core Version:    0.7.0.1
 */