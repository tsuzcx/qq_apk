import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class neh
  implements Application.ActivityLifecycleCallbacks
{
  neh(neg paramneg) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == neg.a(this.a))
    {
      neg.c(this.a);
      this.a.a();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == neg.a(this.a)) {
      neg.b(this.a);
    }
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     neh
 * JD-Core Version:    0.7.0.1
 */