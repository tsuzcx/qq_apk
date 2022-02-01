import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class nmg
  implements Application.ActivityLifecycleCallbacks
{
  nmg(nmf paramnmf) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == nmf.a(this.a))
    {
      nmf.c(this.a);
      this.a.a();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == nmf.a(this.a)) {
      nmf.b(this.a);
    }
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmg
 * JD-Core Version:    0.7.0.1
 */