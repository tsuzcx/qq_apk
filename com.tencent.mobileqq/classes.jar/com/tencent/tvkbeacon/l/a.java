package com.tencent.tvkbeacon.l;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.tvkbeacon.core.a.b;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public final class a
  implements Application.ActivityLifecycleCallbacks
{
  private long a = System.currentTimeMillis();
  private Map<Activity, Long> b = new HashMap();
  private long c = 0L;
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    Object localObject2 = (Long)this.b.get(paramActivity);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(this.a);
    }
    long l1 = System.currentTimeMillis();
    localObject2 = paramActivity.getLocalClassName();
    long l2 = ((Long)localObject1).longValue();
    b.d().a(new a.1(this, l1, (String)localObject2, l1 - l2));
    this.b.remove(paramActivity);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    this.b.put(paramActivity, Long.valueOf(System.currentTimeMillis()));
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.l.a
 * JD-Core Version:    0.7.0.1
 */