package me.ele.uetool;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.uetool.base.Application;

class UETool$LifeCallBack
  implements Application.ActivityLifecycleCallbacks
{
  private AtomicInteger currActivity = new AtomicInteger(0);
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.currActivity.incrementAndGet();
    if ((Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(Application.getApplicationContext()))) {}
    while ((!UETool.access$200()) || (this.currActivity.get() <= 0) || ((UETool.getInstance().getUetMenu() != null) && (UETool.getInstance().getUetMenu().isShown()))) {
      return;
    }
    UETool.access$600(UETool.getInstance(), false);
    UETool.access$300(UETool.getInstance());
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.currActivity.decrementAndGet();
    if ((Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(Application.getApplicationContext()))) {}
    while ((!UETool.access$200()) || (this.currActivity.get() > 0)) {
      return;
    }
    UETool.access$002(false);
    UETool.access$600(UETool.getInstance(), true);
    UETool.dismissUETMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.UETool.LifeCallBack
 * JD-Core Version:    0.7.0.1
 */