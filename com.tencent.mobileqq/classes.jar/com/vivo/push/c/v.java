package com.vivo.push.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.vivo.push.util.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class v
  implements Runnable
{
  v(u paramu, Context paramContext, Map paramMap) {}
  
  public final void run()
  {
    Object localObject1 = this.a.getPackageName();
    Object localObject2 = (ActivityManager)this.a.getSystemService("activity");
    try
    {
      localObject2 = ((ActivityManager)localObject2).getRunningTasks(100);
      if (localObject2 != null)
      {
        Iterator localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          localObject2 = ((ActivityManager.RunningTaskInfo)localIterator.next()).topActivity;
          if (((ComponentName)localObject2).getPackageName().equals(localObject1))
          {
            localObject1 = new StringBuilder("topClassName=");
            ((StringBuilder)localObject1).append(((ComponentName)localObject2).getClassName());
            o.d("OnNotificationClickTask", ((StringBuilder)localObject1).toString());
            localObject1 = new Intent();
            ((Intent)localObject1).setComponent((ComponentName)localObject2);
            ((Intent)localObject1).setFlags(335544320);
            u.a((Intent)localObject1, this.b);
            this.a.startActivity((Intent)localObject1);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      o.a("OnNotificationClickTask", "start recentIntent is error", localException);
      Intent localIntent = this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName());
      if (localIntent != null)
      {
        localIntent.setFlags(268435456);
        u.a(localIntent, this.b);
        this.a.startActivity(localIntent);
        return;
      }
      o.a("OnNotificationClickTask", "LaunchIntent is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.v
 * JD-Core Version:    0.7.0.1
 */